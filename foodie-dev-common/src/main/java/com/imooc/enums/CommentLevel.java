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
public enum CommentLevel {
    GOOD(1,"好评"),
    NORMAL(2,"中评"),
    BAD(3,"差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
