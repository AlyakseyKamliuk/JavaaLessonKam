package Lesson4;


public class Сircle extends Figure {

    private int radiusCircle;

    public Сircle(String name, int radiusCircle) {
        super(name);
        this.radiusCircle = radiusCircle;
    }

    public int getRadius() {
        return radiusCircle;
    }

    public void setRadius(int radiusCircle) {
        this.radiusCircle = radiusCircle;
    }

    public String toString() {
        return "Сircle{" +
                "radiusCircle=" + radiusCircle +
                '}';
    }

    public double perimeter() {
        return 2 * Math.PI * radiusCircle;
    }

    public double area() {
        return Math.PI * radiusCircle * radiusCircle;
    }


}
