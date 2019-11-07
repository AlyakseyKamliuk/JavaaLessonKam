package Lesson4;



public class Сircle extends Figure{

    private int radiusCircle;

    public Сircle(String name, int radiusCircle) {
        super(name);
        this.radiusCircle = radiusCircle;
    }

    public int getRadiusCircle() {
        return radiusCircle;
    }

    public void setRadiusCircle(int radiusCircle) {
        this.radiusCircle = radiusCircle;
    }

    public String toString() {
        return "Сircle{" +
                "radiusCircle=" + radiusCircle +
                '}';
    }

    public void name(){
        System.out.println("Круг");
    }


    public double perimeter(){
        return 2*Math.PI*radiusCircle;
    }

    public double area() {
        return Math.PI*radiusCircle*radiusCircle;
    }



}
