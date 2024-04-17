package com.example.demo.controller;


import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.LoginService;
import com.example.demo.vo.User;

import jakarta.servlet.http.HttpSession;

/**
 * UserController
 *
 * 2024.03.28
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private LoginService loginService;

    /**
     * user検査
     * @param username　ユーザー
     * @param　password パスワード
     */
    @RequestMapping("search1")
    public String login(String username, String password, HttpSession session, Model model) {
        try {
        	LocalDate currentDate = LocalDate.now();// 現在のシステム時刻を取得
            User user = loginService.searchUsers(username, password);// アカウントとパスワードをサービス層に渡し、userを返す           
            session.setAttribute("user", user);
            
            if (username == null || password == null || username == "" || password == "") {
                throw new RuntimeException("ユーザー名とパスワードを入力してください");
            }
            if (user == null) {
                throw new RuntimeException("ユーザー名が間違っています");//ユーザー名がない場合"ユーザー名が間違っています"を返信
            }

            if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
                throw new RuntimeException("パスワードが間違っています");//パスワードが間違ってる場合"パスワードが間違っています"を返信
            }
            if (user.getEndtime().toLocalDate().compareTo(currentDate) < 0) {                
                return "redirect:/reset";// 戻されたendtimeが現在時刻よりも小さい場合、パスワードリセットページにリダイレクト
            } else {               
                return "redirect:/botton";// そうでなければ検索ページに入る
            }

        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login"; // エラーが発生した場合はエラーメッセージを収集し、loginページに戻る
        }
    }

    
    
    
}
