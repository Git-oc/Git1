package com.CloudGoods.controller;

import com.Goods;
import com.Result;
import com.CloudGoods.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/findById/{id}")
    public Goods findById(@PathVariable String id)throws Exception{

        Thread.sleep(1000);

        System.out.println("id"+id);
        return new Goods("小米12pro",5399.0);
    }

    @PostMapping("/save")
    public HashMap save(@RequestBody Goods goods){
        System.out.println(goods);
        return new HashMap(){{
            put("code",200);
            put("msg","goods save success");
        }};
    }

    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/a")
    public String sentinelPush(){
        //实现远程调用CloudJiFen服务
        String forObject = restTemplate.getForObject("http://CloudJiFen/jifen/b", String.class);
        System.out.println(forObject);
        return "a";
    }

    @Resource
    private GoodsService goodsServer;
    @RequestMapping("/kcc")
    public Result kcc (Integer goodId, Integer buyNum){
        return goodsServer.kcc(goodId,buyNum);
    }

}
