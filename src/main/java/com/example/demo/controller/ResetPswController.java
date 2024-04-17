package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bean.Changepws;
import com.example.demo.service.ResetService;

import jakarta.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class ResetPswController {
	
	@Autowired
    private ResetService resetService;

	/**
     * パスワードリセット
     * @param changepws フォーム
     * 
     */
    @PostMapping("reset-password")
    public String resetPassword(Changepws changepws, Model model, HttpSession session) {

        try {
        	resetService.update(changepws);// フロントエンドからのデータを更新パスワードに渡す
            session.invalidate();
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "reset";// エラーが発生した場合はエラーメッセージを収集し、resetページに戻る
        }


        return "redirect:/login";// エラーが発生しない場合はloginページに進む
    }
}