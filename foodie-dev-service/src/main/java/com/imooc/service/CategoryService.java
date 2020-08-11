package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.service
 * @NAME: CategoryService
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 3:30 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 * @Desc:导航栏
 */
public interface CategoryService {
    /**
     * 查询一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 查询二级菜单
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页商品数据
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);


}
