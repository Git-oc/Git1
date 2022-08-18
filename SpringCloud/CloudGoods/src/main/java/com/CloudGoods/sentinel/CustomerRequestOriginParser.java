package com.CloudGoods.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomerRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        System.out.println("come in");

        //获取请求头的source
        String source = request.getHeader("source");
        System.out.println(source);
        return source;
    }

}
