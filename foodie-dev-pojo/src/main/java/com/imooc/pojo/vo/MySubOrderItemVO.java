package com.imooc.pojo.vo;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo.center
 * @NAME: MySubOrderItemVO
 * @USER: code.rookie
 * @DATE: 2020/6/27
 * @TIME: 1:02 下午
 * @DAY_NAME_SHORT: 周六
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public class MySubOrderItemVO {
    private String itemId;
    private String itemImg;
    private String itemName;
    private String itemSpecName;
    private Integer buyCounts;
    private Integer price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
