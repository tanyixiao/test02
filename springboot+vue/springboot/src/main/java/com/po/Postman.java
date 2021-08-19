package com.po;

import lombok.Data;

@Data
public class Postman<T> {
    private Integer code;
    private String msg;
    private T date;
}
