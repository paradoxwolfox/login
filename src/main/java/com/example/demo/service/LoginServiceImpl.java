package com.example.demo.service;

import java.sql.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.bean.Changepws;
import com.example.demo.bean.UserImfor;
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

    @Override
    public User searchUsers(String username, String password) {
        if (username == null || password == null || username == "" || password == "") {
            throw new RuntimeException("ユーザー名とパスワードを入力してください");
        }

        User user = loginMapper.login(username);//アカウントとパスワードをmapper層に渡し、userを返す
        if (user == null) {
            throw new RuntimeException("ユーザー名が間違っています");//ユーザー名がない場合"ユーザー名が間違っています"を返信
        }

        if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
            throw new RuntimeException("パスワードが間違っています");//パスワードが間違ってる場合"パスワードが間違っています"を返信
        }

        return user;
    }

    @Override
    public void update(Changepws changepws) {
        if (changepws.getNewPassword().equals(changepws.getConfirmPassword())) {
            String psw = DigestUtils.md5Hex(changepws.getNewPassword());
            changepws.setNewPassword(psw);// パスワードが新しいパスワードと再入力のパスワードが一致する場合、新しいパスワードを暗号化してデータベースに更新します
            loginMapper.update(changepws);
        } else {
            throw new RuntimeException("パスワードが一致しません");// それ以外の場合は、「パスワードが一致しません」と出力します
        }

    }

	
}
