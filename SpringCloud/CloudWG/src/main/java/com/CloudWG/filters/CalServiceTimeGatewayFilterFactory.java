package com.CloudWG.filters;

import com.CloudWG.predicates.MyConfig;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class CalServiceTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<MyConfig> {

    public CalServiceTimeGatewayFilterFactory() {
        super(MyConfig.class);
    }

    @Override
    public GatewayFilter apply(MyConfig config) {
        return (exchange, chain) -> {
            long startTime = System.currentTimeMillis();

            System.out.println("key："+config.getKey());
            System.out.println("value："+config.getValue());

            return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    long endTime = System.currentTimeMillis();
                    System.out.println("total："+(endTime-startTime));
                })
            );
        };

    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("key","value");
    }
}
