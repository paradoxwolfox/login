package com.example.demo.vo;

import lombok.Data;



/**
*result
*
*2024.03.28
*/
@Data
public class result {
    private int code;
    private String message;
    private Object data;

    public static result ok(Object... data) {
    	result result = new result();
        result.setCode(200);
        result.setMessage("成功");
        if (data.length == 0) {
            result.setMessage(null);
        } else {
            result.setData(data[0]);
        }
        return result;
    }

    public static result error(String... message) {
    	result result = new result();
        result.setCode(500);
        if (message.length == 0) {
            result.setMessage("系统出错请联系管理员");
        } else {
            result.setMessage(message[0]);
        }


        result.setData(null);
        return result;
    }
}