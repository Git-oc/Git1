package com.CloudOrder.sentinel;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;

public class DegradeExceptionHander {

    public static String sentonel6Hander(String flag,Throwable throwable){

        if (throwable instanceof DegradeException){
            return "系统开小差，请稍后重试";
        }else{
            return "非sentinel异常";
        }


    }

}
