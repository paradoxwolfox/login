package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;



/**
*AddressBook
*
*2024.03.28
*/
@Data
public class AddressBook {
    private Integer id;
    private String addressBookName;
    private String ownerGroup;
    private String project;
    private Date createDate;
}
