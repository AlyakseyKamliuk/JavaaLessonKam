package Lesson5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopZD2 implements Shop {

    private Map<Product, Integer> mapProduct = new HashMap<>();
    private Check check = new Check();

    public ShopZD2() {
        super();
    }

    public void generateCheckProduct(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<Product, Integer> p : mapProduct.entrySet()) {
                if (p.getKey().getId() == list.get(i)) {
                    if (p.getValue() <= 0) {
                        mapProduct.remove(p.getKey());
                        break;
                    }
                    check.addProductInCheck(p.getKey());
                    p.setValue(p.getValue() - 1);
                    break;
                }
            }
        }
    }


    public void deleteProductFromShop(Product product) {
        mapProduct.remove(product);
    }

    public void printCheck() {
        check.generateCheck();
    }

    public void addProduct(Product product) {
        if (!mapProduct.containsKey(product)) {
            mapProduct.put(product, 1);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
        }
    }


    public Map<Product, Integer> getMapProduct() {
        return mapProduct;
    }

    public void setMapProduct(Map<Product, Integer> mapProduct) {
        this.mapProduct = mapProduct;
    }


    public String toString() {
        return "ShopZD2{" +
                "mapProduct=" + mapProduct +
                '}';
    }
}
