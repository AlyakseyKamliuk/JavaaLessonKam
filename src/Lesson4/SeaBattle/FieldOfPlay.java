package Lesson4.SeaBattle;

import java.util.Arrays;

public class FieldOfPlay {

    private int[][] field=new int[10][10];

    public int[][] getField() { return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public void positionTheShipsOnTheField(){
        ActionsWithShips actionsWithShips=new ActionsWithShips();
        for (int i = 0; i < 10; i++) {
        actionsWithShips.selectedShipToLocation(Main.ship[i],Main.ship[i].getSizeNumberOfCells());
        }
        int[][] arrayShipTmp=new int[10][10];
        for (int i = 0; i < Main.ship.length; i++)
        for (int j = 0; j < Main.ship[i].getxYlocation().size(); j++) {
            arrayShipTmp[Main.ship[i].getxYlocation().get(j).getLocationX()][Main.ship[i].getxYlocation().get(j).getLocationY()]=1;
            setField(arrayShipTmp);
        }

    }

    public void printField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
              if (field[i][j]!=0) {System.out.printf("[]");} else {System.out.printf("  ");}
                if (j==9) System.out.println();
            }
        }
    }

    public String toString() {
        return "FieldOfPlay{" +
                "field=" + Arrays.toString(field) +
                '}';
    }
}
