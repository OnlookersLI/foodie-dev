package com.imooc.pojo.bo;

/**
 * @PACKAGE_NAME: com.imooc.pojo.bo
 * @NAME: SubmitOrderBO
 * @USER: code.rookie
 * @DATE: 2020/6/23
 * @TIME: 8:39 下午
 * @DAY_NAME_SHORT: 周二
 * @PROJECT_NAME: foodie-dev
 * @Desc:接受orders
 */
public class SubmitOrderBO {
    private String userId;
    private String itemSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemSpecIds() {
        return itemSpecIds;
    }

    public void setItemSpecIds(String itemSpecIds) {
        this.itemSpecIds = itemSpecIds;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getLeftMsg() {
        return leftMsg;
    }

    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    @Override
    public String toString() {
        return "SubmitOrderBO{" +
                "userId='" + userId + '\'' +
                ", itemSpecIds='" + itemSpecIds + '\'' +
                ", addressId='" + addressId + '\'' +
                ", payMethod=" + payMethod +
                ", leftMsg='" + leftMsg + '\'' +
                '}';
    }
}
