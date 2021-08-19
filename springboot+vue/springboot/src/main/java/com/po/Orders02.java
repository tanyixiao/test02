package com.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Orders02<T,E,K> {
    private T good;
    private E tag_name;
    private K type_name;
}
