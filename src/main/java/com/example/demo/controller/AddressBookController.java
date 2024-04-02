package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.SearchRequest;
import com.example.demo.service.AddressBookService;
import com.example.demo.vo.AddressBook;
import com.example.demo.vo.result;




/**
*AddressBookController
*
*2024.03.28
*/
@Controller
@CrossOrigin
public class AddressBookController{

	
	@Autowired
	private AddressBookService addressBookService;
    	
	//search機能
	@PostMapping("/search")
	public String searchAddressBooks(SearchRequest searchRequest,Model model){
	    List<AddressBook> list = addressBookService.searchAddressBooks(searchRequest);//値をサービス層に渡し、listを返す
	    model.addAttribute("list",list);//listをフロントエンドのモデルに渡す
	    return "botton";
	}
	
	@RequestMapping("delete")
    public String delete(Integer id) {
		addressBookService.delete(id);
    	return "botton";
    }

}



