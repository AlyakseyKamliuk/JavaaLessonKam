package Lesson5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopZD2 implements Shop {

    private Map<Product, Integer> mapProduct = new HashMap<>();
    private Map<Integer, Product> idToProduct = new HashMap<>();


    public ShopZD2() {
        super();
    }

    public Check generateCheckProduct(List<Integer> requiredProductIds) {
        Check check = new Check();
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

    public void removeProductFromShop(Product product, int requiredProductId) {
        mapProduct.remove(product);
        idToProduct.remove(requiredProductId);
    }

    public void printCheck(Check check) {
        check.generateCheck();
    }

    public void addProduct(Product product) {
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

    public String toString() {
        return "ShopZD2{" +
                "mapProduct=" + mapProduct +
                '}';
    }
}
