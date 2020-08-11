package com.imooc.service.impl.center;

import com.github.pagehelper.PageInfo;
import com.imooc.utils.PagedGridResult;

import java.util.List;

/**
 * @PACKAGE_NAME: com.imooc.service.impl.center
 * @NAME: BaseService
 * @USER: code.rookie
 * @DATE: 2020/6/27
 * @TIME: 1:24 下午
 * @DAY_NAME_SHORT: 周六
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
public class BaseService {
    public PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
