package com.example.demo.bean;

import lombok.Data;

@Data
public class Changepws {
	private String username;
	private String newPassword;
	private String confirmPassword;
}
