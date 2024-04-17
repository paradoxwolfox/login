package com.example.demo.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SearchRequest;
import com.example.demo.bean.reporter;
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
    
	/**
     * すべてのデータ検査機能
     * @param 
     * 
     */
	@Override
	public List<AddressBook> searchAll() {
		List<AddressBook> list=addressBookMapper.searchAll();
		return list;
	}
	/**
     * search機能
     * @param searchRequest　フォーム
     * 
     */
	@Override
    public List<AddressBook> searchAddressBooks(SearchRequest searchRequest){
    	List<AddressBook> list = addressBookMapper.searchAddressBooks(searchRequest);//アカウントとパスワードをmapper層に渡し、listを返す
    	return list;
    };
    
    /**
     * delete機能
     * @param id　
     * 
     */
    @Override
	public void delete(Integer id) {
		
    	addressBookMapper.delete(id);
	}

    /**
     * IDを基準に情報を表示する
     * @param id
     * 
     */
	@Override
	public List<showinfo> show(Integer id) {
		List<showinfo> list = addressBookMapper.show(id);
		return list;
	}

	/**
     * 更新機能
     * @param showinfo　フォーム
     * 
     */
	@Override
	public void change(showinfo showinfo) {
		Date currentDate = new Date();
		showinfo.setCreateDate(currentDate);
		addressBookMapper.change(showinfo);
		
	}

	/**
     * 増加機能
     * @param showinfo　フォーム
     * 
     */
	@Override
	public void add(showinfo showinfo) {
		Date currentDate = new Date();
		showinfo.setCreateDate(currentDate);
		addressBookMapper.add(showinfo);
		
	}

	/**
     * reporter検査機能
     * @param 
     * 
     */
	@Override
	public List<reporter> getReporters() {
		List<reporter> list = addressBookMapper.getReporters();
		return list;
	}


}

