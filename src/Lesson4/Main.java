package Lesson4;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Picture picture = new Picture();
        picture.addFigure(new Ball("Ball1", 10));
        picture.addFigure(new Ball("Ball1", 10));
        picture.addFigure(new Ball("Ball1", 10));
        picture.addFigure(new Square("Square1", 5));
        picture.addFigure(new Square("Square1", 5));
        picture.addFigure(new Rectangle("Rectangle2", 12, 5));
        System.out.println(picture.toString());
        System.out.println(picture.getList().get(3).area());
        System.out.println(picture.area());

        picture.numberOfShapesInPicture();

        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(2);
        list2.add(5);
        list2.add(6);
        int[] a={1,2,3,4,5,6};
        int[] b={1,2,3,4,5,6};
        Mathematics mathematics = new Mathematics();

        System.out.println(mathematics.add(list1, list2));


    }


}
