package com.CloudGoods.service;

import com.Goods;
import com.Result;
import com.CloudGoods.mapper.GoodsMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Result kcc(Integer goodsId, Integer buyNum) {

        if (StringUtils.isEmpty(String.valueOf(goodsId))){
            return new Result(false,"参数不合法");
        }

        Goods goods = goodsMapper.selectById(goodsId);
        if (goods == null){
            return new Result(false,"商品不存在");
        }

        goods.setGoodsStock(goods.getGoodsStock()-buyNum);
        int i = goodsMapper.updateById(goods);

        return new Result(i == 1,i==1?"修改成功":"修改失败");
    }

}
