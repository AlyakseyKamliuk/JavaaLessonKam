package com.lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 28.11.2019.
 */
public class ReaderFromAFile {



    public List<Product> addingProductsToAShop(Shop shop, String filePath) {
        String[] mas = null;
        List<Product> list = new ArrayList<Product>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            do {
                if (fileExtension(filePath).contains("csv")) {
                    mas = csvFormat(reader.readLine());
                    list.add(createNewProduct(mas));
                }
                if (fileExtension(filePath).contains("json")) {
                    reader.close();
                    list = createListProducts(filePath);
                }
            } while (mas != null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          return list;
        }
    }

    private Shop addingItemsFromAFileToAStore(Shop shop, List list) {

        for (int i = 0; i < list.size(); i++) {
            shop.addProduct((Product) list.get(i));
        }
        return shop;
    }

    private String[] csvFormat(String string) {
        return string.split(";");
    }

    private String removingExtraCharacters(String string) {
        string = string.replaceAll("\"", "");
        string = string.replaceAll(",", "");
        string = string.trim();
        return string;
    }

    private Product createNewProduct(String[] mas) {
        Product product = null;
        if (mas == null) return product;
        if ("Mouse".equals(mas[0])) {
            product = new Mouse(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        } else if ("Monitor".equals(mas[0])) {
            product = new Monitor(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        } else if ("Keyboard".equals(mas[0])) {
            product = new Keyboard(Integer.parseInt(mas[1]), Double.parseDouble(mas[2]), mas[3]);
        }
        return product;
    }

    private List<Product> createListProducts(String filePath) throws IOException {
        String string = "";
        List<Product> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while (reader.ready()) {
                if (string.contains("}")) {
                    list.add(createNewProduct(definingFieldsOfProduct(string)));
                    string = "";
                }
                string += reader.readLine() + "\n";
            }
        return list;
    }

    private String[] definingFieldsOfProduct(String string) {
        String[] mas = new String[4];
        int indexMas = 0;
        Pattern pattern = Pattern.compile(":.+\n");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            isNumberOfFieldsInTheClassDoesNotMatch(indexMas);
            mas[indexMas] = removingExtraCharacters(string.substring(matcher.start() + 1, matcher.end() - 1));
            indexMas++;
        }
        return mas;
    }

    private void isNumberOfFieldsInTheClassDoesNotMatch(Integer numberOfFields) {
        if (numberOfFields >= 4) {
            Exception e = new IndexOutOfBoundsException("Данные в считываемом файле не соотвестувуют формату класса Product");
            e.printStackTrace();
            throw new IndexOutOfBoundsException();

        }
    }

    private String fileExtension(String filePath) {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }


}
