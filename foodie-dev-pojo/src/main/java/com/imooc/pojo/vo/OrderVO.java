package com.imooc.pojo.vo;

import com.imooc.pojo.bo.ShopcartBO;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.pojo.vo
 * @NAME: OrderVO
 * @USER: code.rookie
 * @DATE: 2020/6/25
 * @TIME: 9:48 上午
 * @DAY_NAME_SHORT: 周四
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public class OrderVO {
    private String orderId;
    private MerchantOrdersVO merchantOrdersVO;

    private List<ShopcartBO> toBeRemovedShopcatdList;

    public List<ShopcartBO> getToBeRemovedShopcatdList() {
        return toBeRemovedShopcatdList;
    }

    public void setToBeRemovedShopcatdList(List<ShopcartBO> toBeRemovedShopcatdList) {
        this.toBeRemovedShopcatdList = toBeRemovedShopcatdList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public MerchantOrdersVO getMerchantOrdersVO() {
        return merchantOrdersVO;
    }

    public void setMerchantOrdersVO(MerchantOrdersVO merchantOrdersVO) {
        this.merchantOrdersVO = merchantOrdersVO;
    }
}
