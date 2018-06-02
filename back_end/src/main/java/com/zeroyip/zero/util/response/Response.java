package com.zeroyip.zero.util.response;

/*
*
* 定义RESTful的响应体的格式
* code  HTTP状态码
* msg   返回的信息
* data  返回的数据
*
* */
public class Response {
    private int code;
    private String msg;
    private Object data;

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
