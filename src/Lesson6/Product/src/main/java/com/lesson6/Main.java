package com.lesson6;

import com.lesson6.Format.CSVFormatterWriter;
import com.lesson6.Format.JSONFormatterReader;
import com.lesson6.Format.JSONFormatterWriter;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Product monitor = new Monitor(15480, 500, "LG");
        Product monitor2 = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        Product keybard = new Keyboard(10120, 25, "4Tech");
        Product keybard2 = new Keyboard(10121, 30, "4Tech-Pro");
        Product keybard3 = new Keyboard(10122, 25, "4Tech");

        List<Product> products=new ArrayList<>();
        products.add(monitor);
        products.add(keybard2);
        products.add(keybard3);

        ShopZD1 shopZD1 = new ShopZD1();

        List<Integer> listTest = new ArrayList<>();
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


        List<Integer> listTest2 = new ArrayList<>();
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(13540);
        listTest2.add(10121);

        ShopZD2 shopZD2 = new ShopZD2();
        Check check=new Check();
        Check check2=new Check();

        ShopFormater shopFormater=new ShopFormater();
        shopZD1.addProduct(shopFormater.createListProducts("test.json"));
        shopZD2.addProduct(shopFormater.createListProducts("test.json"));

        shopZD2.printCheck(shopZD2.generateCheckProduct(listTest2));
        shopZD1.printCheck(shopZD1.generateCheckProduct(listTest2));



         JSONFormatterWriter json=new JSONFormatterWriter();
         json.fileWriteTo(monitor2,"test.json");
         CSVFormatterWriter csvFormatterWriter=new CSVFormatterWriter();
         csvFormatterWriter.fileWriteTo(monitor,"test.csv");
         csvFormatterWriter.fileWriteTo(keybard,"test.csv");



    }
}
