package Lesson4;

public class Ball extends Figure {

    int radiusBall;

    public Ball(String name, int radiusBall) {
        super(name);
        this.radiusBall = radiusBall;
    }

    public int getRadius() {
        return radiusBall;
    }

    public void setRadius(int radiusBall) {
        this.radiusBall = radiusBall;
    }

    public String toString() {
        return "Ball{" +
                "radiusBall=" + radiusBall +
                '}';
    }


    public double perimeter() {
        return 4 * Math.PI * radiusBall * radiusBall;
    }

    public double area() {
        return 4 / 3 * Math.PI * radiusBall * radiusBall * radiusBall;
    }


}
