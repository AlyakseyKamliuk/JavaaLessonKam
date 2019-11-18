package Lesson4;

public abstract class Figure {
    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double perimeter() {
        return 0;
    }

    public double area() {
        return 0;
    }

    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                '}';
    }
}
