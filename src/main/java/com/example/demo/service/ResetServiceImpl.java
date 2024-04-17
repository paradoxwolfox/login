package com.example.demo.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Changepws;
import com.example.demo.dao.RestMapper;

@Service
public class ResetServiceImpl implements ResetService {

    @Autowired
    private RestMapper restMapper;

    /**
     * password検査
     * @param changepws　ニューパスワード
     * 
     */
    @Override
    public void update(Changepws changepws) {
        if (changepws.getNewPassword().equals(changepws.getConfirmPassword())) {
            String psw = DigestUtils.md5Hex(changepws.getNewPassword());
            changepws.setNewPassword(psw);// パスワードが新しいパスワードと再入力のパスワードが一致する場合、新しいパスワードを暗号化してデータベースに更新します
            restMapper.update(changepws);
        } else {
            throw new RuntimeException("パスワードが一致しません");// それ以外の場合は、「パスワードが一致しません」と出力します
        }
    }

	
}