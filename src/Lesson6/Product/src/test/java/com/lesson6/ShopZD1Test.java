package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alex on 17.11.2019.
 */
public class ShopZD1Test {

    ShopZD1 shopZD1Expected = new ShopZD1();
    ShopZD1 shopZD1Actual = new ShopZD1();
    List<Integer> listTest = new ArrayList<Integer>();

    @Before
    public void init(){
        Product monitor = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        Product keybard = new Keyboard(10120, 25, "4Tech");
        Product keybard2 = new Keyboard(10121, 30, "4Tech-Pro");
        Product keybard3 = new Keyboard(10122, 25, "4Tech");
        shopZD1Expected.addProduct(monitor);
        shopZD1Expected.addProduct(mouse);
        shopZD1Expected.addProduct(keybard);
        shopZD1Expected.addProduct(keybard2);
        shopZD1Expected.addProduct(keybard3);
        listTest.add(15480);
        listTest.add(15480);
        listTest.add(10120);
        listTest.add(10122);
        listTest.add(10121);

    }


    @Test
    public void testGenerateCheckProduct() throws Exception {

        double priceExpected=1080;
        Check checkAktual=shopZD1Actual.generateCheckProduct(listTest);

       Assert.assertNotEquals(shopZD1Expected,shopZD1Actual);
       shopZD1Expected=shopZD1Actual;
       Assert.assertEquals(shopZD1Expected,shopZD1Actual);
       Assert.assertEquals(priceExpected,checkAktual.getSum(),0);


    }

    @Test
    public void testRemoveProduct() throws Exception {
        String stringExpected="ShopZD1{productsShop=[Product{id=13540, priceProduct=10.0, nameProduct='4Tech'}, " +
                "Product{id=10120, priceProduct=25.0, nameProduct='4Tech'}," +
                " Product{id=10121, priceProduct=30.0, nameProduct='4Tech-Pro'}, " +
                "Product{id=10122, priceProduct=25.0, nameProduct='4Tech'}]}";
        Product monitor = new Monitor(15480, 500, "LG");
        shopZD1Actual.removeProduct(monitor);
        String stringActual=shopZD1Actual.toString();
        Assert.assertEquals(stringExpected,stringActual);

    }

    @Test
    public void testCopyingListToCheckNotNull(){
        shopZD1Actual.generateCheckProduct(null);
        Assert.assertNull( shopZD1Actual.generateCheckProduct(null));
    }




}