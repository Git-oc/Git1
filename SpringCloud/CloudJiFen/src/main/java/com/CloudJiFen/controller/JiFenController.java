package com.CloudJiFen.controller;

import com.JiFen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jifen")
@RefreshScope
public class JiFenController {

    @RequestMapping("/save")
    public Map save(@RequestBody JiFen jifen){
        System.out.println("调用积分保存接口");
        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","success");
        }};
    }

    @RequestMapping("/update")
    public Map update(@RequestBody JiFen jifen){
        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","success");
        }};
    }

    @RequestMapping("/delete")
    public Map deleteById(@RequestParam("jifenId") Integer jifenId){
        System.out.println("删除id为"+jifenId+"的积分信息");
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","success");
        }};
    }

    @RequestMapping("/{jifenId}")
    public JiFen findJiFenById(@PathVariable Integer jifenId){
        System.out.println("查询到"+jifenId+"的积分数据");
        return new JiFen(jifenId,12,jifenId+"号积分");
    }

    @RequestMapping("/search")
    public JiFen search(@RequestParam("uid") Integer uid,@RequestParam("type") String type){
        System.out.println("uid："+uid+"\t"+"type："+type);
        return new JiFen(uid,12,type);
    }

    @RequestMapping("/searchByEntity")
    public List<JiFen> searchMap(@RequestBody JiFen jifen){
        System.out.println(jifen);

        List<JiFen> jifens = new ArrayList<>();
        jifens.add(new JiFen(110,12,"下单积分"));
        jifens.add(new JiFen(111,18,"支付积分"));
        return jifens;
    }

    @Value("${pic.url}")
    private String URL;
    @RequestMapping("/test1")
    public String test1(){
        return URL;
    }

    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/b")
    public String sentinelPush(){
        //远程调用CloudOrder服务
        String forObject = restTemplate.getForObject("http://CloudOrder/order/c", String.class);
        System.out.println(forObject);
        return "b";
    }


}
