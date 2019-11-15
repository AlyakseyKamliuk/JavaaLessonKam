package Lesson5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopZD2 implements Shop {

    private Map<Product, Integer> mapProduct = new HashMap<>();
    private Check check = new Check();
    private Map<Integer,Product> productSearch=new HashMap<>();

    public ShopZD2() {
        super();
    }

    public Check generateCheckProduct(List<Integer> requiredProductIds) {
        for (int i = 0; i < requiredProductIds.size(); i++) {
         copyingListToCheck(requiredProductIds.get(i));
        }
        return check;
    }


    private void copyingListToCheck(int requiredProductIds){
        if (productSearch.containsKey(requiredProductIds)&&(mapProduct.get(productSearch.get(requiredProductIds))!=0)){
            check.addProductInCheck(productSearch.get(requiredProductIds));

            if (mapProduct.get(productSearch.get(requiredProductIds))==1){
                mapProduct.remove(productSearch.get(requiredProductIds));
                productSearch.remove(requiredProductIds);
            }  else {
                mapProduct.put(productSearch.get(requiredProductIds),mapProduct.get(productSearch.get(requiredProductIds))-1);
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
            productSearch.put(product.getId(),product);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
            productSearch.put(product.getId(),product);
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
