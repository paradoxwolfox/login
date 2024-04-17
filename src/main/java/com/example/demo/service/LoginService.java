package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.vo.User;





/**
*LogininService
*
*2024.03.28
*/
@Service
public interface LoginService {

     User searchUsers(String username,String password);


}

