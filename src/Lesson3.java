import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Lesson3 {
    public enum monDay {January, February, March, April, May, June, July, August, September, October, November, December}

    public enum Holiday {
        NEWYER("30.12"),
        CHRISTMAS("5.1"),
        LABORDAY("1.5");


        String date;

        Holiday(String name) {
            this.date = name;
        }

        public String getDate() {
            return date;
        }

        public int getDay() {
            int a = date.lastIndexOf(".");
            String s = date.substring(0, a);
            return Integer.valueOf(s);
        }

        public int getMonth() {
            int a = date.lastIndexOf(".") + 1;
            String s = date.substring(a, date.length());
            return Integer.valueOf(s);
        }


        public String toString() {
            return "holiday{" +
                    "date='" + date + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        System.out.println("Задание 2");
        System.out.printf("In %s %d days \n", monDay.March, daysPerMonth2019(monDay.March));

        int[] array = Lesson2.randomArray(10);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Задание 3");

        System.out.printf("The difference between the minimum and maximum elements of the array: %d \n", differenceMinMax(array));
        System.out.println("Задание 4");
        System.out.println(isTestForEqualityArray(array, array));
        System.out.println("Задание 5");
        int[] testArray = {0, 1, 4, 5, 6, 3, 9, 7, 2, 6, 2, 3};
        System.out.println(findingMissingNumber(testArray));
        int[][] twoDimArray = createTwoDimensionalRandomArray(10, 10, 20, 1);
        System.out.println("Задание 6");
        prinTwoDimArray("", twoDimArray);

        System.out.printf("Min elements: %d \n", minElementTwoDimensionalArray(twoDimArray)[2]);
        System.out.println();
        System.out.println("Задание 7");
        System.out.printf("Max elements: %d \n", maxElementTwoDimensionalArray(twoDimArray)[2]);
        twoDimArray = swapMinMaxElements(twoDimArray);
        prinTwoDimArray("Swap min max elements:", twoDimArray);
        System.out.println();
        twoDimArray = replacingWithPrevious(twoDimArray);
        System.out.println("Задание 8");
        prinTwoDimArray("", twoDimArray);
        System.out.println("Задание 9*");
        prinTwoDimArray("", twoDimArray = createTwoDimensionalRandomArray(5, 5, 10, 1));
        System.out.printf("Result: %d \n", productOfTheDiagonalElements(twoDimArray, 9));
        System.out.println();
        System.out.println("Задание 10**");
        holidayPassed(Holiday.NEWYER);
        holidayPassed(Holiday.CHRISTMAS);
        holidayPassed(Holiday.LABORDAY);

    }


    public static int daysPerMonth2019(monDay month) {

        switch (month) {
            case February:
                return 28;
            case April:
                return 30;
            case May:
                return 31;
            case June:
                return 30;
            case September:
                return 30;
            case November:
                return 30;
            default:
                return 31;
        }
    }

    public static void prinTwoDimArray(String coments, int[][] array) {
        System.out.println(coments);
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
                if (j == array[0].length - 1) System.out.println();
            }
    }

    public static int differenceMinMax(int[] array) {
        return maxElementArray(array) - minElementArray(array);
    }

    public static int minElementArray(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int maxElementArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static boolean isTestForEqualityArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int findingMissingNumber(int[] array) {

        boolean[] cashArr = new boolean[array.length + 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            j = array[i];
            cashArr[j] = true;
        }
        for (int i = 0; i < cashArr.length; i++) {
            if (cashArr[i] == false) return i;
        }
        return -1;
    }

    public static int[][] createTwoDimensionalRandomArray(int n, int m, int maxRandomElement, int minRandomElement) {
        Random random = new Random();
        int max = maxRandomElement;
        int min = minRandomElement;
        int[][] arrays = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrays[i][j] = random.nextInt(max) + min;
            }
        }
        return arrays;
    }

    public static int[] minElementTwoDimensionalArray(int[][] array) {
        int min = array[0][0];
        int[] tmpArray = new int[3];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                    tmpArray[0] = i;
                    tmpArray[1] = j;
                }
                tmpArray[2] = min;
            }
        return tmpArray;
    }

    public static int[] maxElementTwoDimensionalArray(int[][] array) {
        int max = array[0][0];
        int[] tmpArray = new int[3];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    tmpArray[0] = i;
                    tmpArray[1] = j;
                }
            }
        tmpArray[2] = max;
        return tmpArray;
    }

    public static int[][] swapMinMaxElements(int[][] array) {
        int[][] arrayRez = copyArray(array);
        int[] minEllementsTmp = minElementTwoDimensionalArray(array);
        int[] maxEllementsTmp = maxElementTwoDimensionalArray(array);

        arrayRez[minEllementsTmp[0]][minEllementsTmp[1]] = maxEllementsTmp[2];
        arrayRez[maxEllementsTmp[0]][maxEllementsTmp[1]] = minEllementsTmp[2];
        return arrayRez;
    }

    public static int[][] replacingWithPrevious(int[][] array) {
        int[][] arrayRez = copyArray(array);

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] % 2 != 0) {
                    if (i == 0 && j == 0) {
                        array[i][j] = 0;
                        break;
                    }
                    if (j == 0 && i != 0) {
                        array[i][j] = arrayRez[i - 1][array[0].length - 1];
                        break;
                    }
                    array[i][j] = arrayRez[i][j - 1];
                }
            }
        return array;
    }

    public static int[][] copyArray(int[][] array) {
        int[][] arrayRez = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                arrayRez[i][j] = array[i][j];
            }
        return arrayRez;
    }

    public static int productOfTheDiagonalElements(int[][] array, int searchNum) {
        int rez = 1;
        int[] tmpArray = searchEl(array, searchNum);
        if (tmpArray[0] == -1) {
            return -1;
        }
        rez = rez * productOfElementsInIncrements(array, tmpArray[0], tmpArray[1], -1, -1);
        rez = rez * productOfElementsInIncrements(array, tmpArray[0], tmpArray[1], 1, 1);
        rez = rez * productOfElementsInIncrements(array, tmpArray[0], tmpArray[1], -1, 1);
        rez = rez * productOfElementsInIncrements(array, tmpArray[0], tmpArray[1], 1, -1);

        return rez;
    }

    public static int productOfElementsInIncrements(int[][] array, int i, int j, int stepI, int stepJ) {

        int work = 1;

        try {
            i += stepI;
            j += stepJ;
            while (true) {
                if (array[i][j] != 0) {
                    work = work * array[i][j];
                    i += stepI;
                    j += stepJ;
                }
            }
        } catch (Exception e) {
            return work;
        }
    }


    public static int[] searchEl(int[][] array, int searchNum) {
        int[] tmpArray = new int[2];
        tmpArray[0] = -1;
        tmpArray[1] = -1;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == searchNum) {
                    tmpArray[0] = i;
                    tmpArray[1] = j;
                    return tmpArray;
                }
            }
        return tmpArray;
    }

    public static void holidayPassed(Holiday holiday) {

        int days = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getDays();
        int months = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getMonths();
        int years = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getYears();

        if (days <= 0 && months <= 0 && years <= 0) {System.out.printf("%s %s Еще будет \n",holiday.name(),holiday.getDate());}
        else {System.out.printf("%s %s Прошел \n",holiday.name(),holiday.getDate());}

    }
}
