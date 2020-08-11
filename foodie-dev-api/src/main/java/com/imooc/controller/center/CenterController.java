package com.imooc.controller.center;

import com.imooc.pojo.Users;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PACKAGE_NAME: com.imooc.controller.center
 * @NAME: CenterController
 * @USER: code.rookie
 * @DATE: 2020/6/25
 * @TIME: 11:06 下午
 * @DAY_NAME_SHORT: 周四
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
@RestController
@RequestMapping("center")
@Api(value = "用户中心",tags = {"用户中心API"})
public class CenterController {
    @Autowired
    private CenterUserService userService;
    @ApiOperation(value = "获取用户信息",notes ="获取用户信息",httpMethod = "GET")
    @GetMapping("userInfo")
    public IMOOCJSONResult userInfo(
            @ApiParam(name = "用户id",value = "用户id",required = true)
            @RequestParam String userId
    ){
        Users users = userService.queryUserInfo(userId);

        return IMOOCJSONResult.ok(users);
    }

}
