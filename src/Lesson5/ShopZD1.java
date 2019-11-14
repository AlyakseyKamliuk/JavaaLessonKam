package Lesson5;

import java.util.ArrayList;
import java.util.List;


public class ShopZD1 implements Shop {

    private List<Product> listProductShop = new ArrayList<>();

    private Check check = new Check();


    public ShopZD1() {
    }


    public Check generateCheckProduct(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listProductShop.size(); j++) {
                if (listProductShop.get(j).getId() == list.get(i)) {
                    check.addProductInCheck(listProductShop.get(j));
                   j=listProductShop.size()-1;
                }
            }
        }
        return check;
    }

    public void printCheck() {
        check.generateCheck();
    }

    public void addProduct(Product product) {
        if (listProductShop.contains(product)) return;
        listProductShop.add(product);
    }

    public List<Product> getProductShop() {
        return listProductShop;
    }

    public void setProductShop(List<Product> productShop) {
        listProductShop = productShop;
    }


    void removeProduct(Product product) {
        listProductShop.remove(product);
    }

    public String toString() {
        return "ShopZD1{" +
                "listProductShop=" + listProductShop +
                ", check=" + check +
                '}';
    }


}
