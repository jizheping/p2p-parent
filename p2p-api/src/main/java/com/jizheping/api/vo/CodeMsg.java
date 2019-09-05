package com.jizheping.api.vo;

public enum CodeMsg {
    //通用服务
    SUCECC(0,"成功"),
    INTERNAL_ERROR(500,"服务器内部错误"),

    //用户登录服务
    LONGIN_FALL(100001,"用户名或密码输入错误"),

    //账户服务
    ACCOUNT_NOT_EXISTS(200001,"账户不存在"),
    ACCOUNT_CREATE_FALL(200002,"账户创建失败");

    private int code;
    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
