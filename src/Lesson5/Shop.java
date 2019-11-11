package Lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 11.11.2019.
 */
public class Shop{
    private List<Integer> listID=new ArrayList<>();
    private Map<Integer,Product> mapProductShop=new HashMap<>();
    private Check check=new Check();

    public void generateCheckProduct()
    {
        for (int i = 0; i < listID.size(); i++) {
            check.addProductinCheck(mapProductShop.get(listID.get(i)));
        }
        getCheck();
    }

    private void getCheck(){
        check.generateCheck();
    }

    public void addProductinShop(Product product){
       mapProductShop.put(product.getId(),product);
    }

    public Map<Integer, Product> getProductShop() {
        return mapProductShop;
    }

    public void setProductShop(Map<Integer, Product> productShop) {
        mapProductShop = productShop;
    }

    public Shop(){}
    public Shop(List<Integer> listID) {
        this.listID = listID;
    }

    public List<Integer> getListID() {
        return listID;
    }

    public void setListID(List<Integer> listID) {
        this.listID = listID;
    }
}
