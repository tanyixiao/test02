package com.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Good_type implements Serializable {
    private int p_id;
    private String type_name;
    private List<Good> goodLists;
}
