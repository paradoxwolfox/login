package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Changepws;
import com.example.demo.vo.User;





@Mapper
public interface LoginMapper {
	User login(String name);

	void update(Changepws changepws);
}
