package com.po;

import lombok.Data;

import java.util.List;

@Data
public class CommonResult<T> {
    private Long code;
    private String message;
    private  T data;
}
