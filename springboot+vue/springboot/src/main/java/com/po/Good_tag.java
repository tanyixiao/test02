package com.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Good_tag implements Serializable {
    private int t_id;
    private String tag_name;
    private List<Good> goodList;
}
