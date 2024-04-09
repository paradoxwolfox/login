package com.example.demo.service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SearchRequest;
import com.example.demo.dao.AddressBookMapper;
import com.example.demo.vo.AddressBook;
import com.example.demo.vo.showinfo;



/**
*AddressBookServiceImpl
*
*2024.03.28
*/
@Service
public class AddressBookServiceImpl implements AddressBookService {
	@Autowired
	private AddressBookMapper addressBookMapper;
    
	
	//search機能
	@Override
    public List<AddressBook> searchAddressBooks(SearchRequest searchRequest){
    	List<AddressBook> list = addressBookMapper.searchAddressBooks(searchRequest);//アカウントとパスワードをmapper層に渡し、listを返す
    	return list;
    };
    
    @Override
	public void delete(Integer id) {
		
    	addressBookMapper.delete(id);
	}

	@Override
	public List<showinfo> show(Integer id) {
		List<showinfo> list = addressBookMapper.show(id);
		return list;
	}

	@Override
	public void change(showinfo showinfo) {
		Date currentDate = new Date();
		showinfo.setCreateDate(currentDate);
		addressBookMapper.change(showinfo);
		
	}

	@Override
	public void add(showinfo showinfo) {
		Date currentDate = new Date();
		showinfo.setCreateDate(currentDate);
		System.out.println(showinfo);
		addressBookMapper.add(showinfo);
		
	}
}

