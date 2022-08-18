package com.CloudOrder.service;

import com.CloudOrder.mapper.OrderMapper;
import com.JiFen;
import com.Order;
import com.Result;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.api.GoodsAPI;
import com.api.JiFenAPI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private JiFenAPI jiFenAPI;
    @Resource
    private GoodsAPI goodsAPI;
    @Resource
    private OrderMapper orderMapper;

    @SentinelResource("saveOrder[jiFen save]")
    public String saveOrder(){

        Map save = jiFenAPI.save(new JiFen(1, 1, "1"));
        System.out.println(save);
        System.out.println("order save success");

        return "success";

    }

    @Override
    public Result saveOrder(Order order) {

        if (order == null){
            return new Result(false,"下单失败");
        }

        //保存订单
        order.setOrderId(UUID.randomUUID().toString());
        int insert = orderMapper.insert(order);

        //扣减库存
        Result kccResult = goodsAPI.kcc(order.getGoodsId(), order.getOrderNum());

        return new Result(true,"下单成功");
    }

}
