package com.example.demo.Controllers;

public class ResponseMsg {
    private String str;
    public ResponseMsg(String str){
        this.str = str;
    }
    public String getMsg() {
        return str;
    }
}
