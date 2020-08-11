package com.imooc.service.center;


import com.imooc.pojo.OrderItems;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.pojo.bo.center.OrderItemsCommentBO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface CenterUserService {

    /**
     * 根据用户Id查询用户
     * @param userId
     * @return
     */
    Users queryUserInfo(String userId);

    /**
     * 修改用户信息
     * @param userId
     * @param centerUserBO
     * @return
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     * 更新用户头像
     * @param userId
     * @param faceUrl
     * @return
     */
    Users updateUserFace(String userId, String faceUrl);

    /**
     * @PACKAGE_NAME: com.imooc.service.impl.center
     * @NAME: MyCommentsService
     * @USER: code.rookie
     * @DATE: 2020/6/29
     * @TIME: 1:58 下午
     * @DAY_NAME_SHORT: 周一
     * @PROJECT_NAME: foodie-dev
     * @Desc:
     */
    interface MyCommentsService {
        /**
         * 根据订单id查询关联的商品
         * @param orderId
         * @return
         */
        public List<OrderItems> queryPendingComment(String orderId);

        /**
         * 保存用户的评论
         * @param orderId
         * @param userId
         * @param commentList
         */
        public void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);


        /**
         * 我的评价查询 分页
         * @param userId
         * @param page
         * @param pageSize
         * @return
         */
        public PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);
    }
}
