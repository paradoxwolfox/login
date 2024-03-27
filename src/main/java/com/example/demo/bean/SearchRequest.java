package com.example.demo.bean;

import lombok.Data;

@Data
public class SearchRequest {
    private String ownerGroup;
    private String addressBookName;
    private String reporter;
}
