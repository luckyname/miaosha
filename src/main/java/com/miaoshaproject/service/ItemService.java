package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

/**
 * 商品接口
 */
public interface ItemService {
    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表的浏览
    List<ItemModel> listItem();

    //商品详情浏览
    ItemModel   getItemById(Integer id);
}
