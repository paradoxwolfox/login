package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;

/**
*SearchRequest
*
*2024.03.28
*/
@Data
public class User {
	private String username;
    private String password;
    private Date createtime;
    private Date endtime;
}
