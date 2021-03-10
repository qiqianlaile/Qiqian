package com.qf.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by 54110 on 2020/9/1.
 */
@Data
public class BaseResp<T> {

    private List<T> list;

    private Long total;

    private String message;

}
