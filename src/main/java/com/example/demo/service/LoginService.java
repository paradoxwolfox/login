package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Changepws;
import com.example.demo.bean.UserImfor;
import com.example.demo.vo.User;





/**
*LogininService
*
*2024.03.28
*/
@Service
public interface LoginService {

     User searchUsers(String username,String password);

	void update(Changepws changepws);

}

