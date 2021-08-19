package com.po;

import lombok.Data;

@Data
public class good_Comment {
    private int c_id;
    private String cname;
    private Good good;
    private int good_id;
}
