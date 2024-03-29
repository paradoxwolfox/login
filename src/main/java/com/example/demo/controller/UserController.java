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
*LoginController
*
*2024.03.28
*/
@Controller
@CrossOrigin
public class UserController{

	
	@Autowired
	private LoginService loginService;
    

	//search機能
	@RequestMapping("search1")
	public String login(String username,String password,HttpSession session,Model model){
		System.out.println(username+password);
		try {
			
            User user = loginService.searchUsers(username, password);
            LocalDate currentDate = LocalDate.now();
            if (user.getEndtime().toLocalDate().compareTo(currentDate) < 0) {
            	session.setAttribute("user", user);
				return "redirect:/reset";
			}else {
				session.setAttribute("user", user);
	            return "redirect:/botton";
			}
     
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println(e.getMessage());
            return "login"; 
        }
    }
	
	//reset password
	@PostMapping("reset-password")
    public String resetPassword(Changepws changepws,Model model,HttpSession session) {
		
		System.out.println(changepws.getNewPassword()+changepws.getConfirmPassword());
		try {
			loginService.update(changepws);
		} catch (RuntimeException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "reset";// TODO: handle exception
		}
		
        
        return "redirect:/login";
    }
}
	
	

	
	