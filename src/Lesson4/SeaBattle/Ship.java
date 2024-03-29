package Lesson4.SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String nameShip;
    private int shipSize;
    private List<Cell> xYlocation = new ArrayList<>();
    private boolean locatedOnTheMap = false;

    public Ship(String nameShip, int numberOfCells) {
        this.nameShip = nameShip;
        this.shipSize = numberOfCells;
    }

    public void addCell(int locationX, int locationY) {
        xYlocation.add(new Cell(locationX, locationY));
    }

    public boolean isLocatedOnTheMap() {
        return locatedOnTheMap;
    }

    public void setLocatedOnTheMap(boolean locatedOnTheMap) {
        this.locatedOnTheMap = locatedOnTheMap;
    }

    public String getNameShip() {
        return nameShip;
    }


    public int getshipSize() {
        return shipSize;
    }

    public void setshipSize(int sizeNumberOfCells) {
        this.shipSize = sizeNumberOfCells;
    }

    public List<Cell> getxYlocation() {
        return xYlocation;
    }

    public void setxYlocation(List<Cell> xYlocation) {
        this.xYlocation = xYlocation;
    }


    public String toString() {
        return "Ship{" +
                "nameShip='" + nameShip + '\'' +
                ", sizeNumberOfCells=" + shipSize +
                ", xYlocation=" + xYlocation +
                ", locatedOnTheMap=" + locatedOnTheMap +
                '}';
    }
}
