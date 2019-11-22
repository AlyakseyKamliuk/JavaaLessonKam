package com.lesson6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 17.11.2019.
 */
public class ShopZD2Test {
    List<Integer> listTest2 = new ArrayList<Integer>();
    ShopZD2 shopZD2Actual = new ShopZD2();
    ShopZD2 shopZD2Expected = new ShopZD2();

    @Before
    public void init()  {
        Product monitor = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(15480);
        listTest2.add(13540);
        listTest2.add(10120);
        shopZD2Actual.addProduct(monitor);
        shopZD2Actual.addProduct(monitor);
        shopZD2Actual.addProduct(monitor);
        shopZD2Actual.addProduct(mouse);

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

        double priceExpected=1510;
        Check checkAktual=shopZD2Actual.generateCheckProduct(listTest2);
        Assert.assertEquals(priceExpected,checkAktual.getSum(),0);
    }


    @Test
    public void testCopyingListToCheckNotNull(){
        shopZD2Actual.generateCheckProduct(null);
        Assert.assertNull( shopZD2Actual.generateCheckProduct(null));
    }

    @Test
    public void testAddingAnExistingProduct(){
        listTest2.add(10);
        shopZD2Actual.generateCheckProduct(listTest2);
        Assert.assertNull(shopZD2Actual.getProduct(10));
    }

    @Test
    public void testProductIdIsInTheShop(){
        Assert.assertNotNull(shopZD2Actual.getProduct(15480));
    }

    private boolean stringFoundOneTime(String searchStr, String actualString)
    {
        return (actualString.lastIndexOf(searchStr)==actualString.indexOf(searchStr));
    }

    @Test
    public void testGenerateCheckProduct()  {

        double priceExpected=1510;
        Check checkAktual= shopZD2Actual.generateCheckProduct(listTest2);
        Assert.assertNotEquals(shopZD2Expected, shopZD2Actual);
        shopZD2Expected= shopZD2Actual;
        Assert.assertEquals(shopZD2Expected, shopZD2Actual);
        checkAktual.getSum();
        Assert.assertEquals(priceExpected,checkAktual.getSum(),0);

    }


    @Test
    public void testAddListIDNullToTheShop(){
        List<Integer> listTest=null;
        Assert.assertNull(shopZD2Actual.generateCheckProduct(listTest));
    }

    @Test
    public void testAddProductNotNull()  {
       String exception=null;
       Product product=null;

        try {
            shopZD2Actual.addProduct(product);
        } catch (NullPointerException e) {
           exception=e.toString();
        }
        Assert.assertNull(exception);
    }

    @Test
    public void containsProductTest()  {
        Product mouse = new Mouse(13540, 10, "4Tech");
        String stringTest=mouse.toString();
        String stringActual=shopZD2Actual.toString();
        Assert.assertTrue(stringActual.contains(stringTest));
    }

    @Test
    public void testAddProductToTheShop(){
        Product keybard = new Keyboard(10128, 300, "4Tech2");
        shopZD2Actual.addProduct(keybard);
        Assert.assertNotNull(shopZD2Actual.containsProduct(keybard));
    }


    @Test
    public void testNumberInCheck(){
        shopZD2Actual.generateCheckProduct(listTest2);
        Product monitor = new Monitor(15480, 500, "LG");
        Assert.assertEquals(3,shopZD2Actual.numberOfProductsInTheCheck(monitor),0);
    }

    @Test
    public void testEqualsProductInCheck(){
        Product monitor = new Monitor(15480, 500, "LG");
        Assert.assertEquals(monitor,shopZD2Actual.containsProduct(monitor));
    }

}