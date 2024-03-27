package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.vo.AddressBook;
import com.example.demo.bean.SearchRequest;


import java.util.List;

@Service
public interface AddressBookService {
 List<AddressBook> searchAddressBooks(SearchRequest searchRequest);
}
