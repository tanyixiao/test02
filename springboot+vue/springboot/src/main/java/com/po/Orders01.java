package com.po;

import lombok.Data;

import java.util.List;

@Data
public class Orders01<T,S> {
    private List<T> Tlist;
    private List<S> Slist;
}
