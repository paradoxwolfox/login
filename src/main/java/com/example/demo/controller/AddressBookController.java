package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.SearchRequest;

import com.example.demo.vo.result;




/**
*AddressBookController
*
*2024.03.28
*/
@Controller
@CrossOrigin
public class AddressBookController{
//	@RequestMapping("/botton")
//    public String botton()
//    {
//        return "botton";
//    }
	
	@RequestMapping("/search")
	@ResponseBody
	public String searchAddressBooks(@RequestBody SearchRequest searchRequest){
	    System.out.println(searchRequest);
	    return "botton";
	}
}



