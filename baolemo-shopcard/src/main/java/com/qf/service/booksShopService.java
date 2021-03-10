package com.qf.service;

import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;

import javax.servlet.http.HttpServletRequest;

public interface booksShopService {
    BaseResp addbooks(Integer bid, HttpServletRequest request);
    BaseResp  finduserbooks(HttpServletRequest request);
    BaseResp deletebook(Integer bid, HttpServletRequest request);
}
