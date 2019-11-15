package Lesson5;

import java.util.ArrayList;
import java.util.List;


public class ShopZD1 implements Shop {

    private List<Product> productsShop = new ArrayList<>();

    private Check check = new Check();


    public ShopZD1() {
    }



    public Check generateCheckProduct(List<Integer> requiredProductIds) {
        boolean conditionIsMet=false;
        for (int i = 0; i < requiredProductIds.size(); i++) {
            copyingListToCheck(requiredProductIds.get(i));
        }
        return check;
    }


    private void copyingListToCheck(int requiredProductIds){
        for (int j = 0; j < productsShop.size(); j++) {
            if (productsShop.get(j).getId() == requiredProductIds) {
                check.addProductInCheck(productsShop.get(j));
                return;
            }
        }
    }


    public void printCheck() {
        check.generateCheck();
    }

    public void addProduct(Product product) {
        if (productsShop.contains(product)) return;
        productsShop.add(product);
    }

    public List<Product> getProductShop() {
        return productsShop;
    }

    public void setProductShop(List<Product> productShop) {
        productsShop = productShop;
    }


    void removeProduct(Product product) {
        productsShop.remove(product);
    }


    public String toString() {
        return "ShopZD1{" +
                "productsShop=" + productsShop +
                ", check=" + check +
                '}';
    }
}
