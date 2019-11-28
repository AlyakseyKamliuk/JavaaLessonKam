package com.lesson6;

import java.util.ArrayList;
import java.util.List;


public class ShopZD1 implements Shop {

    private static List<Product> productsShop = new ArrayList<Product>();

    Check check=new Check();

    public ShopZD1() {
    }

    public Check generateCheckProduct(List<Integer> requiredProductIds) {

        if (requiredProductIds==null) {return check;}
        for (int i = 0; i < requiredProductIds.size(); i++) {
            copyingListToCheck(requiredProductIds.get(i),check);
        }
        return check;
    }


    private void copyingListToCheck(int requiredProductIds, Check check){
        if (check==null) return;
        for (int j = 0; j < productsShop.size(); j++) {
            if (productsShop.get(j).getId() == requiredProductIds) {
                check.addProductInCheck(productsShop.get(j));
                return;
            }
        }
    }

    public Product containsProduct(Product product){
        for (int i = 0; i < productsShop.size(); i++) {
            if (productsShop.get(i).equals(product)) return product;
        }
        return null;
    }
    public Integer numberOfProductsInTheCheck(Product product){
         return check.numberOfProductsInTheCheck(product);
    }

    public Product getProduct(int idProduct){
        for (int i = 0; i < productsShop.size(); i++) {
            if (productsShop.get(i).getId()==idProduct) {return productsShop.get(i);}
        }
        return null;
    }

    public void printCheck(Check check) {
        System.out.println(check.toString());
    }

    public void addProduct(List<Product> products){
        for (int i = 0; i < products.size(); i++) {
            addProduct(products.get(i));
        }
    }

    public void addProduct(Product product) {
        if (productsShop.contains(product)) return;
        productsShop.add(product);
    }

   private List<Product> getProductShop() {
        return productsShop;
    }

   private void setProductShop(List<Product> productShop) {
        productsShop = productShop;
    }


      void removeProduct(Product product) {
        productsShop.remove(product);
    }


    public String toString() {
        return "ShopZD1{" +
                "productsShop=" + productsShop +
                '}';
    }



}
