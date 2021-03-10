package com.qf.service.impl;

import com.qf.pojo.BaseResp;
import com.qf.pojo.user.books;
import com.qf.repository.booksrepository;
import com.qf.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookServiceimpl implements bookService {
    @Autowired
    booksrepository booksrepository;


    @Override
    public BaseResp findAll() {
        List<books> books = booksrepository.findAll();
        BaseResp baseResp = new BaseResp();
         baseResp.setList(books);
         return baseResp;

    }

    @Override
    public books findById(Integer bid) {
        Optional<books> books = booksrepository.findById(bid);
        return books.get();
    }
}
