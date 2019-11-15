package Lesson5;

import java.util.ArrayList;
import java.util.List;


public class ShopZD1 implements Shop {

    private List<Product> productsShop = new ArrayList<>();




    public ShopZD1() {
    }



    public Check generateCheckProduct(List<Integer> requiredProductIds) {
        Check check = new Check();
        boolean conditionIsMet=false;
        for (int i = 0; i < requiredProductIds.size(); i++) {
            copyingListToCheck(requiredProductIds.get(i),check);
        }
        return check;
    }


    private void copyingListToCheck(int requiredProductIds, Check check){
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
