package com.api;

import com.Goods;
import com.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@FeignClient("CloudGoods")
public interface GoodsAPI {

    @RequestMapping("/goods/findById/{id}")
    Goods findById(@PathVariable String id);

    @PostMapping("/goods/save")
    HashMap save(@RequestBody Goods goods);

    @RequestMapping("/")
    Result kcc(@RequestParam("goodsId") Integer goodsId,@RequestParam("buyNum") Integer buyNum);

}