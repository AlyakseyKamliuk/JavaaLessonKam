package Lesson4;

public class Square extends Figure{
    private int longSide;

    public Square(String name, int longSide) {
        super(name);
        this.longSide = longSide;
    }

    public int getLongSide() {
        return longSide;
    }

    public void setLongSide(int longSide) {
        this.longSide = longSide;
    }

    public void name(){
        System.out.println("Квадрат");
    }


    public double perimeter(){
        return 4*longSide;
    }

    public double area() {
        return longSide*longSide;
    }


    public String toString() {
        return "Square{" +
                "longSide=" + longSide +
                '}';
    }
}
