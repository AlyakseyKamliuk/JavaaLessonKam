package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Picture {
    private List<Figure> list = new ArrayList<>();

    public List<Figure> getList() {
        return list;
    }

    public void setList(List<Figure> list) {
        this.list = list;
    }

    public String toString() {
        return "Picture{" +
                "list=" + list +
                '}';
    }

    public void addFigure(Figure figure){
        this.list.add(figure) ;
    }

    public double perimeter() {
        double perimetrPicture = 0;
        for (int i = 0; i < getList().size(); i++) {
            perimetrPicture += getList().get(i).perimeter();
        }

        return perimetrPicture;
    }

    public double area() {
        double sumAreas = 0;
        for (int i = 0; i < getList().size(); i++) {
            sumAreas += getList().get(i).area();
        }

        return sumAreas;
    }

    public void numberOfShapesInPicture() {
        Map<String, Integer> mapResult = new HashMap<>();
        for (int i = 0; i < getList().size(); i++) {
            if (mapResult.get(getList().get(i).getClass().getSimpleName()) != null) {
                mapResult.put(getList().get(i).getClass().getSimpleName(),mapResult.get(getList().get(i).getClass().getSimpleName()).intValue() + 1);
            } else {
                mapResult.put(getList().get(i).getClass().getSimpleName(), 1);
            }
        }

        for (Map.Entry<String, Integer> map : mapResult.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }


}