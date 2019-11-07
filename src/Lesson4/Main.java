package Lesson4;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Figure> list = new ArrayList<>();
        Figure figure1= new Ball("Ball1",10);
        Figure figure8= new Ball("Ball1",10);
        Figure figure7= new Ball("Ball1",10);
        Figure figure2=new Square("Square1",5);
        Figure figure3 =new Rectangle("Rectangle1",10,15);
        Figure figure4 =new Rectangle("Rectangle2",12,5);
        Figure figure5 =new Сircle("Circle1",10);
        Figure figure6 =new Сircle("Circle2",18);
        list.add(figure1);
        list.add(figure2);
        list.add(figure3);
        list.add(figure4);
        list.add(figure5);
        list.add(figure6);
        list.add(figure7);
        list.add(figure8);

        Picture picture=new Picture(list);
        System.out.println(picture.toString());
        System.out.println(picture.getList().get(3).area());
        picture.name();
        System.out.println(picture.area());

        picture.NumberOfShapesInPpicture();

        List list1=new ArrayList();
        List list2=new ArrayList();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(2);
        list2.add(5);
        list2.add(6);
        Mathematics mathematics=new Mathematics();
        System.out.println(mathematics.add(list1,list2));


    }


}
