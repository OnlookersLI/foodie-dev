package com.imooc.service;


import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {
    /***
     *
     * @param name
     * @return
     */
    public  Boolean queryUserNameIsExist(String name);

    /**
     * 创建用户
     * @param usersDO
     * @return
     */
    Users createUser(UserBO usersDO);

    /**
     * 检索用户名和密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    Users queryUserForLogin(String userName,String password);

}
