package com.imooc.pojo.vo;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo
 * @NAME: CommentLevelCountsVO
 * @USER: code.rookie
 * @DATE: 2020/6/23
 * @TIME: 8:34 上午
 * @DAY_NAME_SHORT: 周二
 * @PROJECT_NAME: foodie-dev
 * @Desc:用户商品评价
 */
public class CommentLevelCountsVO {
    public Integer totalCounts;
    public Integer goodCounts;
    public Integer normalCounts;
    public Integer badCounts;

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodsCounts) {
        this.goodCounts = goodsCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }
}
