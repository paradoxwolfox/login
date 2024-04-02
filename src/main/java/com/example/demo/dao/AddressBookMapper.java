package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.SearchRequest;
import com.example.demo.vo.AddressBook;


/**
*AddressBookMapper
*
*2024.03.28
*/
@Mapper
public interface AddressBookMapper {
    List<AddressBook> searchAddressBooks(SearchRequest searchRequest);
    
    void delete(Integer id);
}