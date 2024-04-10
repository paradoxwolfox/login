package com.example.demo.bean;

import lombok.Data;
import java.util.List;

@Data
public class Test14Form {
	
	// 组合
    private List<Test14SubForm> entityList;

    private String id;
}
