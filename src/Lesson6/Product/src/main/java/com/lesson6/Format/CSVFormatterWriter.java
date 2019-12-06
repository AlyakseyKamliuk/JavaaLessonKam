package com.lesson6.Format;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CSVFormatterWriter implements FormatterWriter {

    private List<String> products = new ArrayList<>();
    private String filePath;

    public void fileWriteTo(Object o, String filePath) {
        String nameClass = "";
        this.filePath=filePath;
        for (Method method : o.getClass().getMethods()) {
            if (method.getName().contains("get")) {

                try {
                    if (nameClass.length()!=0) nameClass+=";";
                    nameClass = nameClass + method.invoke(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        fileWrite(nameClass);
    }


    public void fileWriteTo(List<Object> objects, String filePath) {
        for (int i = 0; i < objects.size(); i++) {
            fileWriteTo(objects.get(i),filePath);
        }
    }

    private void fileWrite(String string) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            if (string != null) {
                writer.write(string+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
