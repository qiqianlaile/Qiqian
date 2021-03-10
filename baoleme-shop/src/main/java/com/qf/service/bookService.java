package com.qf.service;

import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;

public interface bookService {
    BaseResp findAll();
    books findById(Integer bid);

}
