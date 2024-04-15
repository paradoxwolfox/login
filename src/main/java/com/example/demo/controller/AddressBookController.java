package com.example.demo.controller;

import java.util.Arrays;
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
import com.example.demo.bean.Test14Form;
import com.example.demo.bean.Test14SubForm;
import com.example.demo.bean.reporter;
import com.example.demo.service.AddressBookService;
import com.example.demo.vo.AddressBook;
import com.example.demo.vo.result;
import com.example.demo.vo.showinfo;




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
	public String searchAddressBooks(@RequestBody SearchRequest searchRequest,Model model){

	    List<AddressBook> list = addressBookService.searchAddressBooks(searchRequest);//値をサービス層に渡し、listを返す

	    model.addAttribute("list",list);//listをフロントエンドのモデルに渡す
	    return "botton::dataList";
	}
	@RequestMapping("/getReporters")
	public String getReporters(Model model){
	    List<reporter> list=addressBookService.getReporters();

	    model.addAttribute("list1",list);
	    return "botton::getReporters";	    
	}
	@RequestMapping("delete")
    public String delete(Integer id) {
		addressBookService.delete(id);
    	return "botton";
    }

	@RequestMapping("/change")
    public String showlist(Integer id,Model model) {
		List<showinfo> list = addressBookService.show(id);
		model.addAttribute("list",list);
    	return "change";
    }
	
	@RequestMapping("/changeinfo")
    public String change(showinfo showinfo,Model model) {
		addressBookService.change(showinfo);
    	return "redirect:/botton";
    }
	
	@RequestMapping("/save")
    public String add(showinfo showinfo,Model model) {
		addressBookService.add(showinfo);
    	return "redirect:/botton";
    }
	
}



