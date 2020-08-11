package com.imooc.pojo.vo;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo
 * @NAME: CategoryVO
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 4:01 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 * @Desc: 二级菜单VO
 */
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private String fatherId;
    private List<SubCategoryVO> subCatList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }
}
