package Lesson4.SeaBattle;

import java.util.*;

public class ActionsWithShips {

    private final Random random = new Random();
    private Cell[] tmpShip;
    private HashSet<String> occupiedCells = new LinkedHashSet<>();


    public void selectedShipToLocation(Ship ship, int sizeNumberOfCells) {
        int locationX = random.nextInt(10);
        int locationY = random.nextInt(10);
        int placementDirectionOnTheXYaxis = random.nextInt(2);
        int offsetByX = 0;
        int offsetByY = 0;

        tmpShip = new Cell[sizeNumberOfCells];

        switch (placementDirectionOnTheXYaxis) {
            case 0: {//Down
                offsetByX++;
                break;}
            default:{ //Right
            offsetByY++;
            break;}
        }
        for (int i = 0; i < sizeNumberOfCells; i++) {

            if (testLocationShip(locationX,locationY,sizeNumberOfCells)!=false) {

                tmpShip[i]=new Cell();
                tmpShip[i].setLocationX(locationX);
                tmpShip[i].setLocationY(locationY);
                locationX += offsetByX;
                locationY += offsetByY;
                System.gc();
            } else {
                System.gc();
                selectedShipToLocation(ship, sizeNumberOfCells);
            return;}
        }
        for (int i = 0; i < sizeNumberOfCells; i++) {
          ship.addCell(tmpShip[i].getLocationX(),tmpShip[i].getLocationY());
          addOccupiedCells(tmpShip[i].getLocationX(),tmpShip[i].getLocationY());
        }
    }

    private void addOccupiedCells(int locationX,int locationY){
        occupiedCells.add(""+locationX+""+locationY);
        occupiedCells.add(""+(locationX-1)+""+locationY);  //Up
        occupiedCells.add(""+(locationX+1)+""+locationY);  //Down
        occupiedCells.add(""+locationX+""+(locationY-1));  //Left
        occupiedCells.add(""+locationX+""+(locationY+1));  //Right

        occupiedCells.add(""+(locationX-1)+""+(locationY-1));  //Up left
        occupiedCells.add(""+(locationX+1)+""+(locationY-1));  //Down left
        occupiedCells.add(""+(locationX-1)+""+(locationY+1));  //Up right
        occupiedCells.add(""+(locationX+1)+""+(locationY+1));  //Down right

    }

    private boolean testLocationShip(int locationX, int locationY,int sizeNumberOfCells) {

        sizeNumberOfCells--;
        if ((occupiedCells.contains("" + locationX + "" + locationY))
                ||(locationX>=10)
                ||(locationY>=10)) {
            return false;
        } else
            return true;
    }
}