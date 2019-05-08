package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.ItemVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/5/7 17:07
 * @description：商品
 */
@Controller
@RequestMapping("/item")
//用于跨域注解
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;

    /**
     * 注册商品
     * @param title
     * @param description
     * @param price
     * @param stock
     * @param imgUrl
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/createItem" ,method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title") String title,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "stock") Integer stock,
                                       @RequestParam(name = "imgUrl") String imgUrl) throws BusinessException {
        //1.封装service请求
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setDescription(description);
        itemModel.setPrice(price);
        itemModel.setImgUrl(imgUrl);
        itemModel.setStock(stock);
        ItemModel item = itemService.createItem(itemModel);
        ItemVO itemVO = convertVOFromModel(item);
        return CommonReturnType.create(itemVO);
    }

    /**
     * 通过商品id 浏览商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/getItem" ,method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id") Integer id){
        ItemModel items = itemService.getItemById(id);
        ItemVO itemVO = convertVOFromModel(items);
        return CommonReturnType.create(itemVO);
    }
    @RequestMapping(value = "/listItem" ,method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType itemList(){
        List<ItemModel> itemModelList = itemService.listItem();
        /**
         * 使用JDK8  的stream方法 将list内的 itemModel转化成 itemVO  并且是list
         */
        List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = this.convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVOList);
    }
    /************************************* Uitls Start****************************************/
    /**
     * 将ItemModel 转成 传给 前端的ItemVO模型
     * @param itemModel
     * @return
     */
    private ItemVO convertVOFromModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        return itemVO;
    }
    /************************************* Uitls END****************************************/
}
