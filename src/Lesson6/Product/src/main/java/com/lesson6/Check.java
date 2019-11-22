package com.lesson6;

import java.util.HashMap;
import java.util.Map;

public final class Check {
    private final Map<Product, Integer> productMap = new HashMap<Product, Integer>();
    private double sum = 0;

    public void generateCheck() {
        System.out.println("             Check");
        for (Map.Entry<Product, Integer> p : productMap.entrySet()) {
            System.out.printf("%s: %d \n", p.getKey().toString(), p.getValue());
        }
        System.out.printf("            Price: %f \n", sum);
    }


    public void addProductInCheck(Product product) {
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



