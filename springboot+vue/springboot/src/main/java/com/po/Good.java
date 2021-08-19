package com.po;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.sql.Date;
import java.util.List;

@Data
public class Good implements Serializable {
    private int g_id;
    private int price;
    private String good_title;
    private Good_type good_type;
    private int type_id;
    private List<Good_tag> tagList;
    private List<good_Comment> good_commentList;
    private String g_hot;
    private Date dateTime;
}

