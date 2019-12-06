package com.lesson6;

import com.lesson6.Format.JSONFormatterWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

     /*  Product monitor = new Monitor(15480, 500, "LG");
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
        WriterToFile writerToFile=new WriterToFile();
        ReaderFromAFile readerFromAFile=new ReaderFromAFile();
        shopZD1.addProduct(readerFromAFile.addingProductsToAShop(shopZD1, "test.json"));

        writerToFile.fileWrite(products,"test.json");


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
        listTest2.add(10120);
        ShopZD2 shopZD2 = new ShopZD2();
        shopZD2.addProduct(readerFromAFile.addingProductsToAShop(shopZD2,"test.json"));
        shopZD2.printCheck(shopZD2.generateCheckProduct(listTest2)); */

     /*  ProductConsoleReader productConsoleReader=new ProductConsoleReader();
        productConsoleReader.consoleReader();
        System.out.println(productConsoleReader.toString());*/

  /*      ShopFormater shopFormater = new ShopFormater();
        ShopZD1 shopZD1 = new ShopZD1();
        shopZD1.addProduct(shopFormater.createListProducts("test.csv"));
        System.out.println(shopZD1.toString());
        ShopZD2 shopZD2=new ShopZD2();
        shopZD2.addProduct(shopFormater.createListProducts("test.json"));
        System.out.println(shopZD2.toString());*/

 // writerToFile.testingGet(new Product(1,2,""));
    Product keybard2 = new Keyboard(10121, 30, "4Tech-Pro");
    JSONFormatterWriter json=new JSONFormatterWriter();
    json.fileWriteTo(keybard2,"test.json");



    }
}
