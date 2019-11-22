package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckTest {

  private   Check check=new Check();
  private   ShopZD1 shopZD1=new ShopZD1();
  private   ShopZD2 shopZD2=new ShopZD2();
  private   Product monitor = new Monitor(15480, 500, "LG");
  private   Product monitor2 = new Monitor(15480, 500, "LG");
  private   Product monitor3 = new Monitor(15480, 500, "LG");
  private   Product mouse = new Mouse(13540, 10, "4Tech");
  private   List<Integer> listTest=new ArrayList<Integer>();

    @Before
    public void init()  {
        shopZD1.addProduct(monitor);
        shopZD1.addProduct(mouse);
        shopZD2.addProduct(monitor);
        shopZD2.addProduct(mouse);
        listTest.add(15480);
        listTest.add(15480);
        listTest.add(13540);
        listTest.add(13540);
    }

    @Test
    public void testAddCheck(){
        check.addProductInCheck(monitor);
        Assert.assertEquals(500,check.getSum(),0);
    }

    @Test
    public void testAddNullProductToTheCheck(){
        Product monitor = null;
        check.addProductInCheck(monitor);
        Assert.assertEquals(0,check.getSum(),0);
    }

    @Test
    public void testNumberOfProductsInTheCheck() {
         check.addProductInCheck(monitor);
        check.addProductInCheck(monitor2);
        check.addProductInCheck(monitor3);
        check.addProductInCheck(mouse);
        Assert.assertEquals(3, check.numberOfProductsInTheCheck(monitor), 0);
    }



    @Test
    public void testNumberOfNullProductsInTheCheck() {
        Product monitor = null;
        Assert.assertNull(check.numberOfProductsInTheCheck(monitor));
    }

    @Test
    public void testAddListToCheckShopZD1(){
        Check check;
        check=shopZD1.generateCheckProduct(listTest);
        Assert.assertEquals(1020,check.getSum(),0);
    }

    @Test
    public void testAddingListWithNonexistentIDShopZD1(){
        Check check;
        listTest.add(10);
        check=shopZD1.generateCheckProduct(listTest);
        Assert.assertEquals(1020,check.getSum(),0);
    }
    @Test
     public void testAddingListWithNonexistentIDShopZD2(){
        Check check;
        listTest.add(10);
        check=shopZD2.generateCheckProduct(listTest);
        Assert.assertEquals(510,check.getSum(),0);
    }

    @Test
    public void testAddListToCheckShopZD2(){
        Check check;
        check=shopZD2.generateCheckProduct(listTest);
        Assert.assertEquals(510,check.getSum(),0);
    }



    @Test
    public void testAddShopZD1ListIDNullToTheCheck(){
        List<Integer> listTest=null;
        Check check;
        check=shopZD1.generateCheckProduct(listTest);
        Assert.assertEquals(0,check.getSum(),0);
    }
    @Test
    public void testAddShopZD2ListIDNullToTheCheck(){
        List<Integer> listTest=null;
        Check check;
        check=shopZD2.generateCheckProduct(listTest);
        Assert.assertEquals(0,check.getSum(),0);
    }

}