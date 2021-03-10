package com.qf.pojo.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 作者：冯国清
 * 项目名：com.qf.pojo
 * 时间：2020/8/18 15:40
 * 描述:
 */
@Data
@Entity
public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
    private String bookname;
    private String bookauthor;
    private String photograph;
    private String bookzishu;

}
