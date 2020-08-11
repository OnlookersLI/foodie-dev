package com.imooc.service;


import com.imooc.pojo.*;
import com.imooc.pojo.bo.UserBO;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.pojo.vo.ShopCartVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface ItemService {
    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
     Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
     List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
     List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
     ItemsParam queryItemParam(String itemId);

    CommentLevelCountsVO queryCommentCounts(String itemsId);

    /**
     *
     * @param itemId
     * @param level
     * @return更具商品ID查询评价
     */
     PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);
    /**
     *
     * @param keywords
     * @param sort
     * @return 搜索商品列表
     */
     PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 标签查询
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
     PagedGridResult searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 查询最新的购物车商品数据
     * @param spceIds
     * @return
     */
     List<ShopCartVO> queryItemsBySpecIds(String spceIds);

    /**
     * 根据规格获取价格
     * @param specId
     * @return
     */
     ItemsSpec queryItemsSpecById(String specId);


    /**
     * 根据商品查图片
     * @param itemId
     * @return
     */
     String queryItemMainImgById(String itemId);

    /**
     * 减少库存
     * @param itemSpecId
     * @param buyCounts
     */
    void decreaseItemSpecStock(String itemSpecId,Integer buyCounts);

}
