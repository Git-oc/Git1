package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order")
public class Order {

    @TableId(type = IdType.ASSIGN_ID)
    private String orderId;

    private Integer orderNum;

    private Double orderAmount;

    private Integer goodsId;

}
