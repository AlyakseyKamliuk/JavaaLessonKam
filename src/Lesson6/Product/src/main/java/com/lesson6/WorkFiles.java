package com.lesson6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkFiles {
    private BufferedReader reader;
    private BufferedWriter writer;
    private List<String> products = new ArrayList<String>();
    private String filePath = "test.json";
    WriterToFile writerToFile;
    ReaderFromAFile readerFromAFile;

    public WorkFiles(String filePath) {
        this.filePath = filePath;
        writerToFile = new WriterToFile();
        readerFromAFile = new ReaderFromAFile();
    }

    protected class WriterToFile {

        public void fileWrite(Product product) throws IOException {
            try {
                writer = new BufferedWriter(new FileWriter(filePath, true));
                if (fileExtension().contains("json")) {
                    preparingAStringForWritingToJSON(product, 0, 1);
                }
                if (fileExtension().contains("csv")) {
                    preparingAStringForWritingToCSV(product);
                }

            } catch (Exception e) {
                if (e instanceof NullPointerException)
                    e.printStackTrace();
            } finally {
                writer.close();
            }
            fileWrite();
        }

        public void fileWrite(List<Product> product) throws IOException {
            try {
                writer = new BufferedWriter(new FileWriter(filePath, true));
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
    }


    protected class ReaderFromAFile {
        public Shop addingProductsToAShop(Shop shop) throws IOException {
            String[] mas = null;
            List<Product> list = new ArrayList<Product>();
            try {
                reader = new BufferedReader(new FileReader(filePath));
                do {
                    if (fileExtension().contains("csv")) {
                        mas = csvFormat(reader.readLine());
                        list.add(createNewProduct(mas));
                    }
                    if (fileExtension().contains("json")) {
                        list = createListProducts();
                    }
                } while (mas != null);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.close();
                return addingItemsFromAFileToAStore(shop, list);
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

        private List<Product> createListProducts() {
            String string = "";
            List<Product> list = new ArrayList<Product>();
            try {
                while (reader.ready()) {
                    if (string.contains("}")) {
                        list.add(createNewProduct(definingFieldsOfProduct(string)));
                        string = "";
                    }
                    string += reader.readLine() + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
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
    }

    private String fileExtension() {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }

}
