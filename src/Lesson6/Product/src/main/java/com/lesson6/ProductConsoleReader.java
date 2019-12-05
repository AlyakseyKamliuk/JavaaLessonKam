package com.lesson6;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductConsoleReader {
    private int id;
    private double priceProduct;
    private String nameProduct;
    private int typeProduct;
    private int index = 0;
    private TreeMap treeMapProduct = new TreeMap();
    private int enteringMode = 1;


    public void enteringMode() {
        System.out.println("Выберите режим ввода:\n 1. Стандартный\n 2. Упращенный");
    }

    public void consoleReader() {
        boolean isExit = false;
        try {
            Scanner skaner = new Scanner(System.in);

            try {
                enteringMode = skaner.nextInt();
            } catch (Exception e) {
            }

            while (!isExit) {
                message();
                String string = skaner.next();
                if (string.contains("exit")) {
                    isExit = true;
                }
                if (!isExit) {
                    if (enteringMode != 2) {
                        testingEnter(string);
                    } else {
                        testingEnterSimplified(string);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testingEnterSimplified(String string) {
        String[] mas = string.split(" ");
        typeProduct = Integer.parseInt(mas[0]);
        id = Integer.parseInt(mas[1]);
        priceProduct = Double.parseDouble(mas[2]);
        nameProduct = mas[3];
        createNewProduct(typeProduct, id, priceProduct, nameProduct);
    }

    private void testingEnter(String string) {
        try {
            if (index == 0) {
                typeProduct = Integer.parseInt(string);
            }
            if (index == 1) {
                id = Integer.parseInt(string);
            }
            if (index == 2) {
                priceProduct = Double.parseDouble(string);
            }

            if (index == 3) {
                nameProduct = string;
                createNewProduct(typeProduct, id, priceProduct, nameProduct);
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный тип данных! повторите попытку");
            return;
        }
        index++;
    }

    private void message() {
        String[] mas = {"TypeProduct: \n 1. Mouse\n 2. Monitor\n 3. Keyboard", "ID", "priceProduct", "nameProduct"};

        if (index == 4) {
            index = 0;
            System.out.println();
        }
        System.out.println("Enter " + mas[index] + ":");
    }

    private void createNewProduct(int typeProduct, int id, double priceProduct, String nameProduct) {
        switch (typeProduct) {
            case 1:
                treeMapProduct.put(new Mouse(id, priceProduct, nameProduct), "Mouse");
                break;
            case 2:
                treeMapProduct.put(new Monitor(id, priceProduct, nameProduct), "Monitor");
                break;
            case 3:
                treeMapProduct.put(new Keyboard(id, priceProduct, nameProduct), "Keyboard");
                break;
        }
    }


    public String toString() {
        return treeMapProduct.toString();
    }

    private void filereader(String string) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
    }

    private void fileWriter(Map<Product, String> map) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt", true))) {
            for (Map.Entry<Product, String> p : map.entrySet()) {
                bufferedWriter.append(p.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
