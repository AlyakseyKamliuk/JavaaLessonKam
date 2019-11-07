package Lesson4.SeaBattle;

public class Cell {
    private int locationX=0;
    private int locationY=0;

    public Cell() {
    }

    public Cell(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
}
