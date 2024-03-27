package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class AddressBook {
    private Integer id;
    private String addressBookName;
    private String ownerGroup;
    private String project;
    private Date createDate;
}
