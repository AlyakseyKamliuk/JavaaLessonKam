package Lesson4.SeaBattle;

import java.util.*;

public class ActionsWithShips {

    private final Random random = new Random();
    private HashSet<String> occupiedCells = new LinkedHashSet<>();


    public void creationOfRandomShips(Ship ship, int sizeNumberOfCells) {
        int locationX = random.nextInt(10);
        int locationY = random.nextInt(10);
        int placementDirectionOnTheXYaxis = random.nextInt(2);
        int offsetByX = 0;
        int offsetByY = 0;
        Cell[] tmpShip;
        tmpShip = new Cell[sizeNumberOfCells];

        if (placementDirectionOnTheXYaxis == 0) {
            offsetByX++;
        } else {
            offsetByY++;
        }
        for (int i = 0; i < sizeNumberOfCells; i++) {

            if (isCorrectLocation(locationX, locationY, sizeNumberOfCells)) {

                tmpShip[i] = new Cell();
                tmpShip[i].setLocationX(locationX);
                tmpShip[i].setLocationY(locationY);
                locationX += offsetByX;
                locationY += offsetByY;
            } else {
                creationOfRandomShips(ship, sizeNumberOfCells);
                return;
            }
        }
        for (int i = 0; i < sizeNumberOfCells; i++) {
            ship.addCell(tmpShip[i].getLocationX(), tmpShip[i].getLocationY());
            addOccupiedCells(tmpShip[i].getLocationX(), tmpShip[i].getLocationY());
        }
    }

    private void addOccupiedCells(int locationX, int locationY) {
        occupiedCells.add("" + locationX + "" + locationY);
        occupiedCells.add("" + (locationX - 1) + "" + locationY);  //Up
        occupiedCells.add("" + (locationX + 1) + "" + locationY);  //Down
        occupiedCells.add("" + locationX + "" + (locationY - 1));  //Left
        occupiedCells.add("" + locationX + "" + (locationY + 1));  //Right

        occupiedCells.add("" + (locationX - 1) + "" + (locationY - 1));  //Up left
        occupiedCells.add("" + (locationX + 1) + "" + (locationY - 1));  //Down left
        occupiedCells.add("" + (locationX - 1) + "" + (locationY + 1));  //Up right
        occupiedCells.add("" + (locationX + 1) + "" + (locationY + 1));  //Down right

    }

    private boolean isCorrectLocation(int locationX, int locationY, int sizeNumberOfCells) {

        sizeNumberOfCells--;
        return !(occupiedCells.contains("" + locationX + "" + locationY)
                    || (locationX >= 10)
                    || (locationY >= 10));
    }
}