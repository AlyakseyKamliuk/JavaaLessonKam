package com.lesson6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopZD2 implements Shop {

    private Map<Product, Integer> mapProduct = new HashMap<Product, Integer>();
    private Map<Integer, Product> idToProduct = new HashMap<Integer, Product>();
    Check check = new Check();

    public ShopZD2() {
        super();
    }

    public Check generateCheckProduct(List<Integer> requiredProductIds) {

        if (requiredProductIds==null) return null;
        for (int i = 0; i < requiredProductIds.size(); i++) {
            copyingListToCheck(requiredProductIds.get(i), check);
        }
        return check;
    }

    private void copyingListToCheck(int productId, Check check) {
        Integer amountProducts = mapProduct.get(idToProduct.get(productId));
        Product product = idToProduct.get(productId);

        if (idToProduct.containsKey(productId)) {
            incrementProduct(amountProducts, product);
            check.addProductInCheck(product);
        }
    }

    private void incrementProduct(Integer amountProducts, Product product) {
        if (isAmountNot0(amountProducts)) {
            removeProductFromShop(product, product.getId());
        } else {
            mapProduct.put(product, amountProducts - 1);
        }
    }

    private boolean isAmountNot0(int productID) {
        return (productID <= 1);
    }

    private void removeProductFromShop(Product product, int requiredProductId) {
        mapProduct.remove(product);
        idToProduct.remove(requiredProductId);
    }

    public void printCheck(Check check) {
        check.generateCheck();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (!mapProduct.containsKey(product)) {
            mapProduct.put(product, 1);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
        }
        idToProduct.put(product.getId(), product);
    }

    private Map<Product, Integer> getMapProduct() {
        return mapProduct;
    }

    private void setMapProduct(Map<Product, Integer> mapProduct) {
        this.mapProduct = mapProduct;
    }


    public Product containsProduct(Product product){
        if (mapProduct.get(product)!=null) return product;
        return null;
    }

    public Integer numberOfProductsInTheCheck(Product product){
        return check.numberOfProductsInTheCheck(product);
    }

    public Product getProduct(int idProduct){
        return idToProduct.get(idProduct);
    }


    public String toString() {
        return "ShopZD2{" +
                "mapProduct=" + mapProduct +
                '}';
    }
}
