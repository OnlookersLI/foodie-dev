package com.imooc.mapper;

import com.imooc.pojo.OrderStatus;
import com.imooc.pojo.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.imooc.mapper
 * @NAME: OrdersMapperCustom
 * @USER: code.rookie
 * @DATE: 2020/6/27
 * @TIME: 12:56 下午
 * @DAY_NAME_SHORT: 周六
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public interface OrdersMapperCustom {
    public List<MyOrdersVO> queryMyOrders(@Param("paramsMap") Map<String, Object> map);

    public int getMyOrderStatusCounts(@Param("paramsMap") Map<String, Object> map);

    public List<OrderStatus> getMyOrderTrend(@Param("paramsMap") Map<String, Object> map);
}
