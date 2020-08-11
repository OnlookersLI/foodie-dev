package com.imooc.pojo.vo;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo
 * @NAME: SubCategoryVO
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 4:04 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public class SubCategoryVO {
    private Integer subId;
    private String subName;
    private String subType;
    private String subFatherId;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubFatherId() {
        return subFatherId;
    }

    public void setSubFatherId(String subFatherId) {
        this.subFatherId = subFatherId;
    }


}
