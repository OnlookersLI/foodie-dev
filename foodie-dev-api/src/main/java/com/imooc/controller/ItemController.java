package com.imooc.controller;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemInfoVO;
import com.imooc.pojo.vo.ShopCartVO;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.controller
 * @NAME: ItemController
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 9:53 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
@RestController
@RequestMapping("item")
@Api(value = "商品接口",tags = {"商品信息展示的相关接口"})
public class ItemController extends BaseController {
    @Autowired
    private ItemService service;

    @Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
    @RestController
    @RequestMapping("items")
    public class ItemsController {

        @Autowired
        private ItemService itemService;

        @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
        @GetMapping("/info/{itemId}")
        public IMOOCJSONResult info(
                @ApiParam(name = "itemId", value = "商品id", required = true)
                @PathVariable String itemId) {

            if (StringUtils.isBlank(itemId)) {
                return IMOOCJSONResult.errorMsg(null);
            }

            Items item = itemService.queryItemById(itemId);
            List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
            List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
            ItemsParam itemsParam = itemService.queryItemParam(itemId);

            ItemInfoVO itemInfoVO = new ItemInfoVO();
            itemInfoVO.setItem(item);
            itemInfoVO.setItemImgList(itemImgList);
            itemInfoVO.setItemSpecList(itemsSpecList);
            itemInfoVO.setItemParams(itemsParam);

            return IMOOCJSONResult.ok(itemInfoVO);
        }

        @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
        @GetMapping("/commentLevel")
        public IMOOCJSONResult commentLevel(
                @ApiParam(name = "itemId", value = "商品id", required = true)
                @RequestParam String itemId) {

            if (StringUtils.isBlank(itemId)) {
                return IMOOCJSONResult.errorMsg(null);
            }

            CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);

            return IMOOCJSONResult.ok(countsVO);
        }

        @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
        @GetMapping("/comments")
        public IMOOCJSONResult comments(
                @ApiParam(name = "itemId", value = "商品id", required = true)
                @RequestParam String itemId,
                @ApiParam(name = "level", value = "评价等级", required = false)
                @RequestParam Integer level,
                @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
                @RequestParam Integer page,
                @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
                @RequestParam Integer pageSize) {

            if (StringUtils.isBlank(itemId)) {
                return IMOOCJSONResult.errorMsg(null);
            }

            if (page == null) {
                page = 1;
            }

            if (pageSize == null) {
                pageSize = COMMON_PAGE_SIZE;
            }

            PagedGridResult grid = itemService.queryPagedComments(itemId,
                    level,
                    page,
                    pageSize);

            return IMOOCJSONResult.ok(grid);
        }
        @ApiOperation(value = "查询商品列表", notes = "查询商品列表", httpMethod = "GET")
        @GetMapping("/search")
        public IMOOCJSONResult search(
                @ApiParam(name = "keywords", value = "关键字", required = true)
                @RequestParam String keywords,
                @ApiParam(name = "sort", value = "排序", required = false)
                @RequestParam String sort,
                @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
                @RequestParam Integer page,
                @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
                @RequestParam Integer pageSize) {

            if (StringUtils.isBlank(keywords)) {
                return IMOOCJSONResult.errorMsg(null);
            }

            if (page == null) {
                page = 1;
            }

            if (pageSize == null) {
                pageSize = PAGE_SIZE;
            }

            PagedGridResult grid = itemService.searchItems(keywords,
                    sort,
                    page,
                    pageSize);

            return IMOOCJSONResult.ok(grid);
        }
        @ApiOperation(value = "分类搜索", notes = "分类搜索", httpMethod = "GET")
        @GetMapping("/catItems")
        public IMOOCJSONResult catItems(
                @ApiParam(name = "catId", value = "分类id", required = true)
                @RequestParam Integer catId,
                @ApiParam(name = "sort", value = "排序", required = false)
                @RequestParam String sort,
                @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
                @RequestParam Integer page,
                @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
                @RequestParam Integer pageSize) {

            if (catId == null) {
                return IMOOCJSONResult.errorMsg(null);
            }

            if (page == null) {
                page = 1;
            }

            if (pageSize == null) {
                pageSize = PAGE_SIZE;
            }

            PagedGridResult grid = itemService.searchItems(catId,
                    sort,
                    page,
                    pageSize);

            return IMOOCJSONResult.ok(grid);
        }
        //刷新购物车数据
        @ApiOperation(value = "根据商品的规格id查找最新的商品数据", notes = "根据商品的规格id查找最新的商品数据", httpMethod = "GET")
        @GetMapping("/refresh")
        public IMOOCJSONResult refresh(
                @ApiParam(name = "itemSpecIds", value = "拼接的规格Ids", required = true , example = "1001,1003,1005")
                @RequestParam String itemSpecIds)
        {
            if (StringUtils.isBlank(itemSpecIds)){
                return IMOOCJSONResult.ok();
            }
            List<ShopCartVO>  list= itemService.queryItemsBySpecIds(itemSpecIds);
            return  IMOOCJSONResult.ok(list);
        }
    }
}

