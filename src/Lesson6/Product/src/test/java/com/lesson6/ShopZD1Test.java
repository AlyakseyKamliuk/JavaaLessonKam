package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 17.11.2019.
 */
public class ShopZD1Test {

   private ShopZD1 shopZD1Expected = new ShopZD1();
   private ShopZD1 shopZD1Actual = new ShopZD1();
   private List<Integer> listTest = new ArrayList<Integer>();
   private Check check=new Check();
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
        shopZD1Expected.generateCheckProduct(listTest);
    }

    @Test
    public void testThisClassProduct(){
        Product monitor = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        Product keybard = new Keyboard(10120, 25, "4Tech");

        Assert.assertTrue(mouse instanceof Product);
        Assert.assertTrue(keybard instanceof Product);
        Assert.assertTrue(monitor instanceof Product);

    }

    @Test
    public void testCheckPrice() {

        double priceExpected=1080;
        Check checkAktual=shopZD1Actual.generateCheckProduct(listTest);
        Assert.assertEquals(priceExpected,checkAktual.getSum(),0);
    }



    @Test
    public void testRemoveProduct() {
        Product monitor = new Monitor(15480, 500, "LG");
        shopZD1Actual.removeProduct(monitor);
        Assert.assertNull(shopZD1Actual.containsProduct(monitor));
    }

    @Test
    public void testCopyingListToCheckNotNull(){
        shopZD1Actual.generateCheckProduct(null);
        Assert.assertNotNull( shopZD1Actual.generateCheckProduct(null));
    }

    @Test
    public void testAddingAnExistingProduct(){
        Assert.assertNull(shopZD1Actual.getProduct(10));
    }

    @Test
    public void testAddListIDNullToTheShop(){
        List<Integer> listTest=null;
        System.out.println(shopZD1Actual.generateCheckProduct(listTest));
        Assert.assertNotNull(shopZD1Actual.generateCheckProduct(listTest));
    }

    @Test
    public void testAddProductToTheShop(){
        Product keybard = new Keyboard(10128, 300, "4Tech2");
        shopZD1Actual.addProduct(keybard);
        Assert.assertNotNull(shopZD1Actual.containsProduct(keybard));
    }


    @Test
    public void testNumberInShop(){
        Product monitor = new Monitor(15480, 500, "LG");
        Assert.assertEquals(2,shopZD1Expected.numberOfProductsInTheCheck(monitor),0);
    }

    @Test
    public void testEqualsProductInShop(){
        Product monitor = new Monitor(15480, 500, "LG");
        Assert.assertEquals(monitor,shopZD1Expected.containsProduct(monitor));
    }




}