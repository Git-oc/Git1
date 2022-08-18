package com.CloudOrder.controller;

import com.CloudOrder.service.OrderServiceImpl;
import com.Goods;
import com.JiFen;
import com.Order;
import com.Result;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.api.GoodsAPI;
import com.api.JiFenAPI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private JiFenAPI jiFenAPI;

    @RequestMapping("/save")
    public Map save(){

        String serviceName = "CloudGoods";
        String url = "http://"+serviceName+"/goods/findById/1";
        Goods goods = restTemplate.getForObject(url, Goods.class);
        System.out.println(goods);

        System.out.println("save order success");
        return new HashMap(){{
            put("code","200");
            put("msg","order save success");
        }};
    }

    @RequestMapping("/test")
    public String test(){
        String serviceName = "CloudGoods";
        String url = "http://"+serviceName+"/goods/save";

        Goods goods = new Goods("联想r7000",5899.0);

        HashMap hashMap = restTemplate.postForObject(url,goods,HashMap.class);
        System.out.println(hashMap);
//        ResponseEntity<HashMap> result = restTemplate.postForEntity(url, goods, HashMap.class);
//        System.out.println(result.getBody());
//        System.out.println(result.getStatusCode());

        return "success";
    }

    @RequestMapping("/test1")
    public Map test1(){
        JiFen jiFen = new JiFen(1,10,"2");
        return jiFenAPI.save(jiFen);
    }

    @RequestMapping("/test2")
    public Map test2(){
        JiFen jiFen = new JiFen(1,10,"2");
        return jiFenAPI.update(jiFen);
    }

    @RequestMapping("/test3")
    public Map test3(){
        return jiFenAPI.deleteById(1);
    }

    @RequestMapping("/test4")
    public JiFen test4(){
        return jiFenAPI.findJiFenById(1);
    }

    @RequestMapping("/test5")
    public JiFen test5(){
        return jiFenAPI.search(1,"2");
    }

    @RequestMapping("/test6")
    public List<JiFen> test6(){
        JiFen jiFen = new JiFen(1,10,"2");
        return jiFenAPI.searchMap(jiFen);
    }

    @RequestMapping("/sentinel1")    //sentinel流控，QPS超过阈值“直接或关联”失败 测试
    public String sentinel1(){
        return "sentinel1";
    }
    @RequestMapping("/sentinel2")   //sentinel流控，线程超过阈值“直接或关联”失败 测试
    public String sentinel2() throws InterruptedException {
 //       Thread.sleep(1000);   去掉睡眠时间，用jmeter工具进行测试
        return "sentinel2";
    }
    @Resource
    private OrderServiceImpl orderService;
    @RequestMapping("/sentinel3")    //sentinel流控，线程、QPS超过阈值链路失败 测试
    public String sentinel3(){
        orderService.saveOrder();
        return "sentinel3";
    }
    @RequestMapping("/sentinel4")   //sentinel流控，线程、QPS超过阈值链路失败 测试
    public String sentinel4(){
        orderService.saveOrder();
        return "sentinel4";
    }

    @RequestMapping("/sentinel5")   //sentinel熔断降级 慢调用比例 测试
    public String sentinel5(String flag) throws Exception {
        if (flag == null){
            Thread.sleep(1800);
        }
        return "sentinel5";
    }
/*
    @RequestMapping("/sentinel6")   //sentinel熔断降级 异常比例、异常数 测试
    @SentinelResource(value = "sentinel6",fallback = "sentonel6Hander",fallbackClass = {DegradeExceptionHander.class})  //熔断降级自定义异常处理
    public String sentinel6(String flag) {
        if (flag == null){
            throw new IllegalArgumentException("参数异常");
        }
        return "sentinel6";
    }
*/

    @RequestMapping("/sentinel6")   //sentinel熔断降级 异常比例、异常数 测试
    @SentinelResource(value = "sentinel6")  //熔断降级自定义异常处理
    public String sentinel6(String flag) {
        if (flag == null){
            throw new IllegalArgumentException("参数异常");
        }
        return "sentinel6";
    }

    @RequestMapping("/sentinel7")   //sentinel 热点规则 测试
    @SentinelResource("hotkey-sentinel7")
    public String sentinel7(String name,Integer age) {
        System.out.println("name："+name);
        System.out.println("age："+age);
        return "sentinel7";
    }

    @Resource
    private GoodsAPI goodsAPI;
    @RequestMapping("/sentinel8")
    public String sentinel8(){      //sentinel 授权规则 测试
        Goods byId = goodsAPI.findById("1");
        System.out.println(byId);
        return "sentinel8";
    }
/*
    @RequestMapping("/sentinel9")   //流控自定义异常处理
    @SentinelResource(value = "sentinel9",blockHandler = "sentinel9Hander",blockHandlerClass = {BlockExceptionHander.class})
    public String sentinel9(){
        return "sentinel9";
    }
*/

    @RequestMapping("/sentinel9")
    @SentinelResource(value = "sentinel9")  //流控自定义异常处理
    public String sentinel9(){
        return "sentinel9";
    }

    @RequestMapping("/c")
    public String sentinelPush(){
        System.out.println("c");
        return "c";
    }

    @RequestMapping("/save1")
    public Result save1(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

}
