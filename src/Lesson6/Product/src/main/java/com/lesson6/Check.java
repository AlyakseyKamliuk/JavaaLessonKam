package com.lesson6;

import java.util.HashMap;
import java.util.Map;

public final class Check {
    private final Map<Product, Integer> productMap = new HashMap<Product, Integer>();
    private double sum = 0;

    public String toString() {
        String str="             Check\n";
        for (Map.Entry<Product, Integer> p : productMap.entrySet()) {
            str=str+p.getKey().toString()+": "+ p.getValue()+"\n";
        }
        str=str+"            Price:"+sum+"\n";
        return str;
    }


    public void addProductInCheck(Product product) {
        if (product==null) return;
        if (!productMap.containsKey(product)) {
            productMap.put(product, 1);
            sum += product.getPriceProduct();
        } else {
            productMap.replace(product, productMap.get(product) + 1);
            sum += product.getPriceProduct();
        }
    }

    public Integer numberOfProductsInTheCheck(Product product){
        return productMap.get(product);
    }


    public double getSum() {
        return sum;
    }

}



