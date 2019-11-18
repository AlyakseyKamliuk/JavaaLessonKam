package Lesson4.SeaBattle;

import java.util.Arrays;

public class FieldOfPlay {


    private int multiplierSizeGame = 1;

    private Ship[] ship = {
            new Ship("FourTiered", 4 * multiplierSizeGame),
            new Ship("ThreeTiered", 3 * multiplierSizeGame),
            new Ship("ThreeTiered", 3 * multiplierSizeGame),
            new Ship("TwoTiered", 2 * multiplierSizeGame),
            new Ship("TwoTiered", 2 * multiplierSizeGame),
            new Ship("TwoTiered", 2 * multiplierSizeGame),
            new Ship("OneTiered", 1 * multiplierSizeGame),
            new Ship("OneTiered", 1 * multiplierSizeGame),
            new Ship("OneTiered", 1 * multiplierSizeGame),
            new Ship("OneTiered", 1 * multiplierSizeGame)};

    private int fieldSize = 10 * multiplierSizeGame;
    private int[][] field = new int[fieldSize][fieldSize];

    public FieldOfPlay(int multiplierSizeGame) {
        if (multiplierSizeGame <= 0) {
            multiplierSizeGame = 1;
        }
        this.multiplierSizeGame = multiplierSizeGame;
        this.fieldSize *= multiplierSizeGame;
        for (int i = 0; i < 10; i++) {
            this.ship[i].setshipSize(ship[i].getshipSize() * multiplierSizeGame);
        }
    }

    public void changingSizeGame(int multiplierSizeGame) {
        this.multiplierSizeGame = multiplierSizeGame;
    }

    private int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public void positionTheShipsOnTheField() {
        ActionsWithShips actionsWithShips = new ActionsWithShips();
        for (int i = 0; i < ship.length; i++) {
            actionsWithShips.creationOfRandomShips(ship[i], ship[i].getshipSize(), multiplierSizeGame);
        }
        int[][] arrayShipTmp = new int[10 * multiplierSizeGame][10 * multiplierSizeGame];
        for (int i = 0; i < ship.length; i++)
            for (int j = 0; j < ship[i].getxYlocation().size(); j++) {
                arrayShipTmp[ship[i].getxYlocation().get(j).getLocationX()][ship[i].getxYlocation().get(j).getLocationY()] = 1;
                setField(arrayShipTmp);
            }

    }


    public void printField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] != 0) {
                    System.out.printf("[]");
                } else {
                    System.out.printf("  ");
                }
                if (j == fieldSize - 1) System.out.println();
            }
        }
    }

    public String toString() {
        return "FieldOfPlay{" +
                "field=" + Arrays.toString(field) +
                '}';
    }
}
