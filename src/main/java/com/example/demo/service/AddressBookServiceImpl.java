package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SearchRequest;
import com.example.demo.dao.AddressBookMapper;
import com.example.demo.vo.AddressBook;

@Service
public class AddressBookServiceImpl implements AddressBookService {
	@Autowired
	private AddressBookMapper addressBookMapper;
    
	@Override
    public List<AddressBook> searchAddressBooks(SearchRequest searchRequest){
    	List<AddressBook> list = addressBookMapper.searchAddressBooks(searchRequest);
    	System.out.println(list);
    	return list;
    };
}

