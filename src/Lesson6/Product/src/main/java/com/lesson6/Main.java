package com.lesson6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product monitor = new Monitor(15480, 500, "LG");
        Product monitor2 = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        Product keybard = new Keyboard(10120, 25, "4Tech");
        Product keybard2 = new Keyboard(10121, 30, "4Tech-Pro");
        Product keybard3 = new Keyboard(10122, 25, "4Tech");

        ShopZD1 shopZD1 = new ShopZD1();
        shopZD1.addProduct(monitor);
        shopZD1.addProduct(monitor2);
        shopZD1.addProduct(mouse);
        shopZD1.addProduct(keybard);
        shopZD1.addProduct(keybard2);
        shopZD1.addProduct(keybard3);
        List<Integer> listTest = new ArrayList<Integer>();
        listTest.add(15480);
        listTest.add(15480);
        listTest.add(15480);
        listTest.add(15480);
        listTest.add(13540);
        listTest.add(10120);
        listTest.add(10120);
        listTest.add(10122);
        listTest.add(10121);

        shopZD1.printCheck(shopZD1.generateCheckProduct(listTest));


        List<Integer> listTest2 = new ArrayList<Integer>();
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(13540);
        listTest2.add(10120);
        ShopZD2 shopZD2 = new ShopZD2();
        shopZD2.addProduct(monitor);
        shopZD2.addProduct(monitor);
        shopZD2.addProduct(monitor);
        shopZD2.addProduct(mouse);
        shopZD2.printCheck(shopZD2.generateCheckProduct(listTest2));

    }
}
