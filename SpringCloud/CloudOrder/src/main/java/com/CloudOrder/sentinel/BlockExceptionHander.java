package com.CloudOrder.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockExceptionHander {

    public static String sentinel9Hander(BlockException e){
        return "系统繁忙，请稍后重试";
    }

}
