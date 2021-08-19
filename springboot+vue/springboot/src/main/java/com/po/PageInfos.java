package com.po;

import lombok.Data;

import java.util.List;
@Data
public class PageInfos<T> {
    private int currPage;//当前页数
    private int pageSize;//每页显示的记录数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private List<T> lists;//每页的显示的数据

}
