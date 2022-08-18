package com.CloudWG.predicates;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class MyHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<MyConfig> {

    public MyHeaderRoutePredicateFactory() {
        super(MyConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyConfig config) {
        return serverWebExchange -> {

            String value = serverWebExchange.getRequest().getHeaders().getFirst(config.getKey());

            if (StringUtils.isEmpty(config.getValue())){
                if (StringUtils.isEmpty(value)){
                    return false;
                }else {
                    return true;
                }
            }else{
                if (StringUtils.isEmpty(value)){
                    return false;
                }else {
                    if (value.equals(config.getValue())){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("key","value");
    }
}
