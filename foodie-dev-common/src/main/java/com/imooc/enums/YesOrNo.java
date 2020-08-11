package com.imooc.enums;

/**
 * @PACKAGE_NAME: com.imooc.enums
 * @NAME: YesOrNo
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 3:00 下午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 */
public enum  YesOrNo {
    NO(0,"否"),
    YES(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
