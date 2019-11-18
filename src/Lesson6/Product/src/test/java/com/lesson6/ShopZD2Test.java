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
    public void init() throws Exception {
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
    public void testGenerateCheckProduct() throws Exception {

        double priceExpected=1510;
        Check checkAktual= shopZD2Actual.generateCheckProduct(listTest2);

        Assert.assertNotEquals(shopZD2Expected, shopZD2Actual);
        shopZD2Expected= shopZD2Actual;
        Assert.assertEquals(shopZD2Expected, shopZD2Actual);
        checkAktual.getSum();
        Assert.assertEquals(priceExpected,checkAktual.getSum(),0);

    }

    @Test
    public void testAddProductNotNull() throws Exception {
       String exception = null;
        try {
            shopZD2Actual.addProduct(null);
        } catch (NullPointerException e) {
            exception=e.toString();
        }
        Assert.assertNull(exception);
    }

    @Test
    public void containsProductTest() throws Exception {
        String stringTest="{id=15480, priceProduct=500.0, nameProduct='LG'";
        String stringActual=shopZD2Actual.toString();

        Assert.assertTrue(stringActual.contains(stringTest));

    }



}