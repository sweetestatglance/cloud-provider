package com.cnct.util;

/**
 * Created by wangwenchao
 * 2018/9/25.
 */
public class Message {
    /**
     * 状态码
     */
    int code;
    /**
     * 返回消息
     */
    String msg;

    public Message(int code, String msg) {
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
