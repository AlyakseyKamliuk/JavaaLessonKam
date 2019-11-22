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
    public void testThisClassProduct(){
        Product monitor = new Monitor(15480, 500, "LG");
        Product mouse = new Mouse(13540, 10, "4Tech");
        Product keybard = new Keyboard(10120, 25, "4Tech");

        Assert.assertTrue(mouse instanceof Product);
        Assert.assertTrue(keybard instanceof Product);
        Assert.assertTrue(monitor instanceof Product);

    }

    @Test
    public void testTypeMismatches(){
        String strError=null;
        Mouse mouseError;
        try {
            mouseError=new Mouse(Integer.parseInt(strError), 10, "4Tech");
        } catch (NumberFormatException e) {
            strError=e.toString();
        }

        Assert.assertNotNull(strError);
    }


    @Test
    public void testShopEquals(){
        Assert.assertNotEquals(shopZD1Expected,shopZD1Actual);
        shopZD1Expected=shopZD1Actual;
        Assert.assertEquals(shopZD1Expected,shopZD1Actual);
    }

    @Test
    public void testCheckPrice() {

        double priceExpected=1080;
        Check checkAktual=shopZD1Actual.generateCheckProduct(listTest);
        Assert.assertEquals(priceExpected,checkAktual.getSum(),0);
    }



    @Test
    public void testRemoveProduct() {
        String stringExpected;
        String stringActual;
        stringExpected=shopZD1Actual.toString();
        Product monitor = new Monitor(15480, 500, "LG");
        shopZD1Actual.removeProduct(monitor);
        stringActual=shopZD1Actual.toString();
        Assert.assertNotEquals(stringExpected,stringActual);
    }

    @Test
    public void testCopyingListToCheckNotNull(){
        shopZD1Actual.generateCheckProduct(null);
        Assert.assertNull( shopZD1Actual.generateCheckProduct(null));
    }

    @Test
    public void testAddingAnExistingProduct(){
        listTest.add(10);
        String str=shopZD1Actual.toString();
        Assert.assertNotEquals("id=10",str);
    }

    @Test
    public void testAddListIDNullToTheShop(){
        List<Integer> listTest=null;
        Assert.assertNull(shopZD1Actual.generateCheckProduct(listTest));
    }

    @Test
    public void testProductIdIsInTheShop(){
        listTest.add(15480);
        String str=shopZD1Actual.toString();
        Assert.assertTrue(stringFoundOneTime("id=15480",str));

    }

    private boolean stringFoundOneTime(String searchStr, String actualString)
    {
       return (actualString.lastIndexOf(searchStr)==actualString.indexOf(searchStr));
    }

}