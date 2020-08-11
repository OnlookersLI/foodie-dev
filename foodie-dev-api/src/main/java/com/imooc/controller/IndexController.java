package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CarouseService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import com.imooc.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.controller
 * @NAME: IndexComtroller
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 2:52 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 */
@RestController
@RequestMapping("index")
@Api(value = "注册登陆",tags = {"首页展示的相关借口"})
public class IndexController {
    @Autowired
    private CarouseService service;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisOperator redisOperator;
    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
        List<Carousel> list = new ArrayList<>();
       String carouselStr = redisOperator.get("carousel");
       if (StringUtils.isBlank(carouselStr)){

           list =  service.queryAll(YesOrNo.YES.type);
//           if (list != null && list.size()>0 ){
               redisOperator.set("carousel", JsonUtils.objectToJson(list));
//           }else {
//               redisOperator.set("carousel", JsonUtils.objectToJson(list),5*60);
//           }

       }else{
          list = JsonUtils.jsonToList(carouselStr,Carousel.class);
       }
        return IMOOCJSONResult.ok(list);
    }

    /**
     * 1、第一次刷新，大分类
     * 2、选择大分类加载小分类、如果以及有了，就不加载
     */
    @ApiOperation(value = "获取导航栏一级分类",notes = "获取导航栏一级分类",httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats(){
        List<Category> list =  categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);
    }
    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }

        List<CategoryVO> list = new ArrayList<>();
        String catsStr = redisOperator.get("subCat:" + rootCatId);
        if (StringUtils.isBlank(catsStr)) {
            list = categoryService.getSubCatList(rootCatId);

            /**
             * 查询的key在redis中不存在，
             * 对应的id在数据库也不存在，
             * 此时被非法用户进行攻击，大量的请求会直接打在db上，
             * 造成宕机，从而影响整个系统，
             * 这种现象称之为缓存穿透。
             * 解决方案：把空的数据也缓存起来，比如空字符串，空对象，空数组或list
             */
            if (list != null && list.size() > 0) {
                redisOperator.set("subCat:" + rootCatId, JsonUtils.objectToJson(list));
            } else {
                redisOperator.set("subCat:" + rootCatId, JsonUtils.objectToJson(list), 5*60);
            }
        } else {
            list = JsonUtils.jsonToList(catsStr, CategoryVO.class);
        }

//        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }

        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(list);
    }

}
