package com.lesson6;

import java.util.ArrayList;
import java.util.List;


public class ShopZD1 implements Shop {

    private static List<Product> productsShop = new ArrayList<Product>();




    public ShopZD1() {
    }



    public Check generateCheckProduct(List<Integer> requiredProductIds) {
        Check check = new Check();
        if (requiredProductIds==null) {return null;}
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


    public void printCheck(Check check) {
        check.generateCheck();
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
