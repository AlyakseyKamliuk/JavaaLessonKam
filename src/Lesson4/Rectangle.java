package Lesson4;

public class Rectangle extends Figure{
    private int length,width;

    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }


    public void name(){
        System.out.println("Прямоугольник");
    }


    public double perimeter(){
        return 2*(length+width);
    }

    public double area() {
        return length*width;
    }


}
