package com.CloudWG.sentinel;


import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MySentinelGatewayBlockExceptionHandler implements WebExceptionHandler {

    private List<ViewResolver> viewResolvers;
    private List<HttpMessageWriter<?>> messageWriters;
    private final Supplier<ServerResponse.Context> contextSupplier = () -> {
        return new ServerResponse.Context() {
            @Override
            public List<org.springframework.http.codec.HttpMessageWriter<?>> messageWriters() {
                return MySentinelGatewayBlockExceptionHandler.this.messageWriters;
            }

            @Override
            public List<ViewResolver> viewResolvers() {
                return MySentinelGatewayBlockExceptionHandler.this.viewResolvers;
            }
        };
    };

    public MySentinelGatewayBlockExceptionHandler(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer){
        this.viewResolvers = viewResolvers;
        this.messageWriters = serverCodecConfigurer.getWriters();
    }

    //自定义异常处理
    private Mono<Void> writeResponse(ServerResponse response1,ServerWebExchange exchange){
        ServerHttpResponse response = exchange.getResponse();
        //不能放行，直接返回json信息
        response.getHeaders().add("Content-Type","application/json;charset=UTF-8");

        Map res = new HashMap(){{
            put("success",false);
            put("msg","系统繁忙，请稍后重试！");
        }};

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try{
            jsonStr = objectMapper.writeValueAsString(res);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        DataBuffer dataBuffer = response.bufferFactory().wrap(jsonStr.getBytes());
        //响应json数据
        return response.writeWith(Flux.just(dataBuffer));

    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable throwable) {
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(throwable);
        } else {
            return !BlockException.isBlockException(throwable)?Mono.error(throwable):this.handleBlockedRequest(exchange,throwable).flatMap(
                    response -> this.writeResponse(response,exchange)
            );
        }
    }

    private Mono<ServerResponse> handleBlockedRequest(ServerWebExchange exchange, Throwable throwable){
        return GatewayCallbackManager.getBlockHandler().handleRequest(exchange,throwable);
    }

}
