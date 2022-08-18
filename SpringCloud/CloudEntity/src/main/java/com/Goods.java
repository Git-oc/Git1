package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {

    @TableId(type = IdType.ASSIGN_ID)
    private Integer goodsId;

    private Integer goodsStock;

    private String goodsName;

    private Double goodsPrice;

    public Goods(String goodsName, Double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }
}
