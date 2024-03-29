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



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User searchUsers(String username, String password) {
        if (username == null || password == null || username == "" || password == "") {
            throw new RuntimeException("用户名和密码不能为空");
        }

        User user = loginMapper.login(username);
        System.out.println(DigestUtils.md5Hex(password));
        if (user == null) {
            throw new RuntimeException("用户名有误");
        }

        if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
            throw new RuntimeException("密码有误");
        }

        return user;
    }

	@Override
	public void update(Changepws changepws) {
		if (changepws.getNewPassword().equals(changepws.getConfirmPassword()) ) {
			String psw = DigestUtils.md5Hex(changepws.getNewPassword());
			changepws.setNewPassword(psw);
			loginMapper.update(changepws);
		}else {
			throw new RuntimeException("两次输入的密码不一样");
		}
		
	}
}

