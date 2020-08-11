package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author code.rookie
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper mapper;
    @Autowired
    private Sid sid;
    private static  final String USER_FACE = "http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/267f9e2f07082838685c484ab999a9014c08f11f.jpg";
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);
        Users users =  mapper.selectOneByExample(userExample);
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO usersDO) {
        String userId = sid.nextShort();
        Users users = new Users();
        users.setId(userId);
        users.setUsername(usersDO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(usersDO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称同用户名
        users.setNickname(usersDO.getUsername());
        //默认头像
        users.setFace(USER_FACE);
        //默认生日
        users.setBirthday(DateUtil.stringToDate("1990-01-01"));
        //设置默认性别为保密
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        mapper.insert(users);
        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUserNameIsExist(String name) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria =  userExample.createCriteria();
        userCriteria.andEqualTo("username",name);
       Users users =  mapper.selectOneByExample(userExample);
        return users == null ? false : true;
    }
}
