package com.lesson6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 28.11.2019.
 */
public class WriterToFile {


    private BufferedWriter writer;
    private List<String> products = new ArrayList<String>();
    private String filePath = "test.json";


    public void fileWrite(Product product, String filePath) throws IOException {
        try {
            writer = new BufferedWriter(new FileWriter(filePath, true));
            this.filePath=filePath;
            if (fileExtension().contains("json")) {
                preparingAStringForWritingToJSON(product, 0, 1);
            }
            if (fileExtension().contains("csv")) {
                preparingAStringForWritingToCSV(product);
            }

        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            writer.close();
        }
        fileWrite();
    }

    public void fileWrite(List<Product> product, String filePath) throws IOException {
        try {
            writer = new BufferedWriter(new FileWriter(filePath, true));
            this.filePath=filePath;
            if (fileExtension().contains("json"))
                for (int i = 0; i < product.size(); i++) {
                    preparingAStringForWritingToJSON(product.get(i), i, product.size());
                }

            if (fileExtension().contains("csv"))
                for (int i = 0; i < product.size(); i++) {
                    preparingAStringForWritingToCSV(product.get(i));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        fileWrite();
    }

    private void fileWrite() throws IOException {
        if (fileExtension().contains("json")) {
            String string = overwriteExistingProducts();
            writer = new BufferedWriter(new FileWriter(filePath));
            if (string != null) {
                writer.write(string);
            }
        }

        if (fileExtension().contains("csv")) writer = new BufferedWriter(new FileWriter(filePath, true));

        for (int i = 0; i < products.size(); i++) {
            writer.append(products.get(i));
        }
        writer.close();
        products = new ArrayList<String>();
    }

    private void preparingAStringForWritingToJSON(Product product, int indexElement, int listProductSize) throws IOException {

        if ((products.size() == 0) && (overwriteExistingProducts().length() == 0)) {
            products.add("[\n");
        }
        String string = product.toJSON();
        if (indexElement < listProductSize - 1) {
            products.add(string + ",\n");
        } else {
            products.add(string + "\n]");
        }
    }

    public void preparingAStringForWritingToCSV(Product product) throws IOException {
        String nameClass = product.getClass().getName().substring(product.getClass().getName().lastIndexOf(".") + 1);
        nameClass = nameClass + ";" + product.getId() + ";" + product.getPriceProduct() + ";" + product.getNameProduct() + "\n";
        products.add(nameClass);
    }

    private String overwriteExistingProducts() throws IOException {
        String str = null;
        String rez = "";
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            do {
                str = reader.readLine();
                if (str != null) {
                    rez += str + "\n";
                } else if (rez.length() != 0) {
                    rez = rez.substring(0, rez.length() - 3);
                    rez += ",\n";
                }
            } while (str != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return rez;
    }

    private String fileExtension() {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }
}
