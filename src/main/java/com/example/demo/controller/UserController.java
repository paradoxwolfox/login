package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.bean.Changepws;
import com.example.demo.bean.UserImfor;
import com.example.demo.service.LoginService;
import com.example.demo.vo.User;
import com.example.demo.vo.result;

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

    // 検索機能
    @RequestMapping("search1")
    public String login(String username, String password, HttpSession session, Model model) {
        try {

            User user = loginService.searchUsers(username, password);// アカウントとパスワードをサービス層に渡し、userを返す
            LocalDate currentDate = LocalDate.now();// 現在のシステム時刻を取得
            if (user.getEndtime().toLocalDate().compareTo(currentDate) < 0) {
                session.setAttribute("user", user);
                return "redirect:/reset";// 戻されたendtimeが現在時刻よりも小さい場合、パスワードリセットページにリダイレクト
            } else {
                session.setAttribute("user", user);
                return "redirect:/botton";// そうでなければ検索ページに入る
            }

        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login"; // エラーが発生した場合はエラーメッセージを収集し、loginページに戻る
        }
    }

    // パスワードリセット
    @PostMapping("reset-password")
    public String resetPassword(Changepws changepws, Model model, HttpSession session) {

        try {
            loginService.update(changepws);// フロントエンドからのデータを更新パスワードに渡す
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "reset";// エラーが発生した場合はエラーメッセージを収集し、resetページに戻る
        }


        return "redirect:/login";// エラーが発生しない場合はloginページに進む
    }
}
