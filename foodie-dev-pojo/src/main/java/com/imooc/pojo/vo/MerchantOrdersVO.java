package com.imooc.pojo.vo;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo
 * @NAME: MerchantOrdersVO
 * @USER: code.rookie
 * @DATE: 2020/6/25
 * @TIME: 9:48 上午
 * @DAY_NAME_SHORT: 周四
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public class MerchantOrdersVO {
    private String merchantOrderId;         // 商户订单号
    private String merchantUserId;          // 商户方的发起用户的用户主键id
    private Integer amount;                 // 实际支付总金额（包含商户所支付的订单费邮费总额）
    private Integer payMethod;              // 支付方式 1:微信   2:支付宝
    private String returnUrl;               // 支付成功后的回调地址（学生自定义）

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
