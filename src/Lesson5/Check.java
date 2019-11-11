package Lesson5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11.11.2019.
 */
public class Check {
   private List <Product> productList=new ArrayList<>();

    public void generateCheck()
    {
        double sum=0;
        System.out.println("                Check");
        for (int i = 0; i < productList.size(); i++) {
            sum+=productList.get(i).getPriceProduct();
            System.out.printf("%d:%d %s %f\n",i, productList.get(i).getId(),productList.get(i).getNameProduct(),productList.get(i).getPriceProduct());

        }
        System.out.printf("            Price: %f \n",sum);
    }


    public void addProductinCheck(Product product){
        productList.add(product);
    }


}



