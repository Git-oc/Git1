package com.CloudOrder.exception;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomerExceptionHandler {

    //流控规则，全局异常处理
    @ExceptionHandler(FlowException.class)
    @ResponseBody
    public Map handlerFlowException(){
        return new HashMap(){{
            put("code","5xx");
            put("msg","系统繁忙，请稍后重试");
        }};
    }

    //熔断降级规则，全局异常处理
    @ExceptionHandler(DegradeException.class)
    @ResponseBody
    public Map handlerDegradeException(){
        return new HashMap(){{
            put("code","5xx");
            put("msg","系统开小差，请稍后重试");
        }};
    }

    //熔断降级规则，全局异常处理
    @ExceptionHandler(AuthorityException.class)
    @ResponseBody
    public Map handlerAuthorityException(){
        return new HashMap(){{
            put("code","5xx");
            put("msg","没有权限访问");
        }};
    }

}
