package com.imooc.config;

import com.imooc.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.imooc.config
 * @NAME: OrderJob
 * @USER: code.rookie
 * @DATE: 2020/6/25
 * @TIME: 8:00 下午
 * @DAY_NAME_SHORT: 周四
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
@Component
public class OrderJob {
    private OrderService orderService;
    @Scheduled(cron = " 0 0 0/1 * * ?")
    public void autoClose(){
        orderService.closeOrder();
    }
}
