package Lesson4;

public class Ball extends Figure{

    int radiusBall;

    public Ball(String name, int radiusBall) {
        super(name);
        this.radiusBall = radiusBall;
    }

    public int getRadiusBall() {
        return radiusBall;
    }

    public void setRadiusBall(int radiusBall) {
        this.radiusBall = radiusBall;
    }

    public String toString() {
        return "Ball{" +
                "radiusBall=" + radiusBall +
                '}';
    }

    public void name(){
        System.out.println("Шар");
    }


    public double perimeter(){
        return 4*Math.PI*radiusBall*radiusBall;
    }

    public double area() {
        return  4/3*Math.PI*radiusBall*radiusBall*radiusBall;
    }



}
