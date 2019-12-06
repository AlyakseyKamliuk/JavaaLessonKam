package com.lesson6;


import com.lesson6.Format.CSVFormatterReader;
import com.lesson6.Format.JSONFormatterReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 28.11.2019.
 */
public class ShopFormater {

    private List<Product> listProduct = new ArrayList<Product>();

    public List<Product> createListProducts(String filePath) {
        
                if (fileExtension(filePath).contains("csv")) {

                    CSVFormatterReader csv=new CSVFormatterReader();
                    createListProduct(csv.formaterTo(filePath));
                }
                if (fileExtension(filePath).contains("json")) {
                    JSONFormatterReader json=new JSONFormatterReader();
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
        if ("Mouse".equals(mas[0])) {
            product = new Mouse(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        } else if ("Monitor".equals(mas[0])) {
            product = new Monitor(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        } else if ("Keyboard".equals(mas[0])) {
            product = new Keyboard(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        }
        return product;
    }
    

    private String fileExtension(String filePath) {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }


}
