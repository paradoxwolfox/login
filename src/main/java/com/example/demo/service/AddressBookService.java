package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.vo.AddressBook;
import com.example.demo.vo.showinfo;
import com.example.demo.bean.SearchRequest;
import com.example.demo.bean.reporter;

import java.util.List;



/**
*AddressBookService
*
*2024.03.28
*/
@Service
public interface AddressBookService {
 List<AddressBook> searchAddressBooks(SearchRequest searchRequest);
 
	void delete(Integer id);

	List<showinfo> show(Integer id);

	void change(showinfo showinfo);

	void add(showinfo showinfo);

	List<reporter> getReporters();
}
