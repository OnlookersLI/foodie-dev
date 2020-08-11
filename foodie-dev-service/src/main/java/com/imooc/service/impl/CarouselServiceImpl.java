package com.imooc.service.impl;

import com.imooc.mapper.CarouselMapper;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.service.impl
 * @NAME: CarouselServiceImpl
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 2:47 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 */
@Service
public class CarouselServiceImpl implements CarouseService {
    @Autowired
    private CarouselMapper mapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);
       List<Carousel> list = mapper.selectByExample(example);
        return list;
    }
}
