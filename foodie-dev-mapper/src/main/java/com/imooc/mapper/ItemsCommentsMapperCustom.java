package com.imooc.mapper;

/**
 * @PACKAGE_NAME: com.imooc.mapper
 * @NAME: ItemsCommentsMapperCustom
 * @USER: code.rookie
 * @DATE: 2020/6/29
 * @TIME: 2:06 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.ItemsComments;
import com.imooc.pojo.vo.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    public void saveComments(Map<String, Object> map);

    public List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);

}
