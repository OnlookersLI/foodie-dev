package com.imooc.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.chart.ValueAxis;

@ApiModel(value = "用户对象BO",description = "从客户端由用户传入的数据封装在次entity")
public class UserBO {
    @ApiModelProperty(value = "用户名",name = "username",example = "hhh",required = true)
    private String username;
    @ApiModelProperty(value = "密码",name = "password",example = "123456",required = true)
    private String password;
    @ApiModelProperty(value = "确认密码",name = "confirmPassword",example = "123456",required = false)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserBO(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserBO() {
    }
}