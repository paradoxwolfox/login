package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginMapper;
import com.example.demo.vo.User;

/**
 * LoginServiceImpl
 *
 * 2024.03.28
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * user検査
     * @param username　ユーザー
     * @param　password パスワード
     */
    @Override
    public User searchUsers(String username, String password) {
        User user = loginMapper.login(username);//アカウントとパスワードをmapper層に渡し、userを返す       
        return user;
    }
	
}
