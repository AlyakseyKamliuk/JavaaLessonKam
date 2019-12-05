package com.lesson6;


import com.lesson6.Format.CSVFileReader;
import com.lesson6.Format.JSONFileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 28.11.2019.
 */
public class ShopFormater {

    private List<Product> listProduct = new ArrayList<Product>();

    public List<Product> createListProducts(String filePath) {
        
                if (fileExtension(filePath).contains("csv")) {

                    CSVFileReader csv=new CSVFileReader();
                    createListProduct(csv.formaterTo(filePath));
                }
                if (fileExtension(filePath).contains("json")) {
                    JSONFileReader json=new JSONFileReader();
                    createListProduct(json.formaterTo(filePath));
                }
          return listProduct;
    }

    private void createListProduct(ArrayList<String[]> list){
        for (int i = 0; i < list.size(); i++) {
            listProduct.add(createNewProduct(list.get(i)));
        }
    }

    

    private Product createNewProduct(String[] mas) {
        Product product = null;
        if (mas == null) return product;
        if ("Mouse".equals(mas[3])) {
            product = new Mouse(Integer.parseInt(mas[0]), Double.parseDouble(mas[1]), mas[2]);
        } else if ("Monitor".equals(mas[3])) {
            product = new Monitor(Integer.parseInt(mas[0]), Double.parseDouble(mas[1]), mas[2]);
        } else if ("Keyboard".equals(mas[3])) {
            product = new Keyboard(Integer.parseInt(mas[0]), Double.parseDouble(mas[1]), mas[2]);
        }
        return product;
    }
    

    private String fileExtension(String filePath) {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }


}
