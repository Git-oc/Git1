package com.CloudOrder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import rule.MyRule;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.api")     //开启openFeign
@RibbonClient(name = "CloudGoods",configuration = {MyRule.class})
@MapperScan(basePackages = {"com.CloudOrder.mapper"})
public class CloudOrderApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderApp.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }

}
