package com.lesson6;

import java.util.List;

public interface Shop {

    void addProduct(Product product);


    Check generateCheckProduct(List<Integer> list);


}
