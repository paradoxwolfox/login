package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Changepws;

/**
*AddressBookService
*
*2024.03.28
*/
@Service
public interface ResetService {

	void update(Changepws changepws);
 
}