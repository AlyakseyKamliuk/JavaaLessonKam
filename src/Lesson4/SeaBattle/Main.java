package Lesson4.SeaBattle;


public class Main {
    public static final Ship[] ship={
            new Ship("FourTiered",4),
            new Ship("ThreeTiered",3),
            new Ship("ThreeTiered",3),
            new Ship("TwoTiered",2),
            new Ship("TwoTiered",2),
            new Ship("TwoTiered",2),
            new Ship("OneTiered",1),
            new Ship("OneTiered",1),
            new Ship("OneTiered",1),
            new Ship("OneTiered",1),
    };

    public static void main(String[] args) {

        FieldOfPlay fieldOfPlay=new FieldOfPlay();
        fieldOfPlay.positionTheShipsOnTheField();
        fieldOfPlay.printField();

    }
}
