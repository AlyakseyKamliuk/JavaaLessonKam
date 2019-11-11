package Lesson5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11.11.2019.
 */
public class Main {
    public static void main(String[] args) {
        Product monitor = new Monitor(15480,500,"LG");
        Product Mouse= new Mouse(13540,10,"4Tech");
        Product Keybard= new Keyboard(10120,25,"4Tech");
        Product Keybard2= new Keyboard(10121,30,"4Tech-Pro");
        Product Keybard3= new Keyboard(10122,25,"4Tech");

        Shop shop=new Shop();
        shop.addProductinShop(monitor);
        shop.addProductinShop(Mouse);
        shop.addProductinShop(Keybard);
        shop.addProductinShop(Keybard2);
        shop.addProductinShop(Keybard3);
        List<Integer> listTest=new ArrayList<>();
        listTest.add(15480);
        listTest.add(13540);
        listTest.add(10120);
        listTest.add(10120);
        listTest.add(10122);
        listTest.add(10121);




        shop.setListID(listTest);
        shop.generateCheckProduct();



    }
}
