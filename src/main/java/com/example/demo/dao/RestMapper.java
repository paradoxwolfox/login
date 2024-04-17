package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Changepws;

@Mapper
public interface RestMapper {

	void update(Changepws changepws);

	
}