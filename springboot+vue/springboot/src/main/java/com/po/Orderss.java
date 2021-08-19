package com.po;

import lombok.Data;

import java.util.List;

@Data
public class Orderss {
    private Good good;
    private List<Good_tag> tagList;
    private String good_type;
}
