package com.worksap.springboot.service;

/**
 * Created by zzl on 16-12-28.
 */
public class HelloService {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public String sayHello() {
        return "Hello" + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
