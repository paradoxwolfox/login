package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.SearchRequest;
import com.example.demo.bean.reporter;
import com.example.demo.service.AddressBookService;
import com.example.demo.vo.AddressBook;
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
    
	/**
     * 初期化データー検査
     * 
     * 
     */
	@PostMapping("/init")
	public String searchAll(Model model){

	    List<AddressBook> list = addressBookService.searchAll();//値をサービス層に渡し、listを返す

	    model.addAttribute("list",list);//listをフロントエンドのモデルに渡す
	    return "botton::dataList";
	}
	
	/**
     * 検査機能
     * @param searchRequest　フォーム
     * 
     */
	@PostMapping("/search")
	public String searchAddressBooks(@RequestBody SearchRequest searchRequest,Model model){
		try {
			List<AddressBook> list = addressBookService.searchAddressBooks(searchRequest);//値をサービス層に渡し、listを返す
		    model.addAttribute("list",list);//listをフロントエンドのモデルに渡す
		    return "botton::dataList";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/botton";
		}
	    
	}
	
	/**
     * レポーターを表示する
     * 
     * 
     */
	@RequestMapping("/getReporters")
	public String getReporters(Model model){
		try {
			List<reporter> list=addressBookService.getReporters();
		    model.addAttribute("list1",list);
		    return "botton::getReporters";	
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/botton";
		}
	        
	}
	
	/**
     * 削除機能
     * @param id　
     * 
     */
	@RequestMapping("delete")
    public String delete(Integer id,Model model) {
		try {
			List<AddressBook> list = addressBookService.searchAll();
			addressBookService.delete(id);
			model.addAttribute("list", list);
	    	return "redirect:/botton";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/botton";
		}
		
    }
	
	/**
     * 変更ページにジャンプ
     * @param id　
     * 
     */
	@RequestMapping("/change")
    public String showlist(Integer id,Model model) {
		List<showinfo> list = addressBookService.show(id);
		model.addAttribute("list",list);
    	return "change";
    }
	
	/**
     * 更新機能
     * @param showinfo フォーム
     * 
     */
	@RequestMapping("/changeinfo")
    public String change(showinfo showinfo,Model model) {
		try {
			addressBookService.change(showinfo);
	    	return "redirect:/botton";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "change";
		}
		
    }
	
	/**
     * 増加機能
     * @param showinfo フォーム
     * 
     */
	@RequestMapping("/save")
    public String add(showinfo showinfo,Model model) {
		try {
			addressBookService.add(showinfo);
	    	return "redirect:/botton";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "add";
		}
		
    }
	
}



