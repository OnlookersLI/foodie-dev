package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom  {
    /**
     *返回菜单
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 返回首页每个一级菜单前6个商品
     * @param map
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String,Object> map);

}