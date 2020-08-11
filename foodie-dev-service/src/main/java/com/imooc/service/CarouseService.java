package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.service
 * @NAME: CarouseService
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 2:43 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 */
public interface CarouseService {
    /**
     *
     * @param isShow
     */
    List<Carousel> queryAll(Integer isShow);
}
