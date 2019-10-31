import java.util.Random;

public class Lesson3 {

    public static void main(String[] args) {

        System.out.println("Задание 2");
        System.out.printf("In %s %d days \n", MonDay.MARCH, daysPerMonth2019(MonDay.MARCH));
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
        Holiday.CHRISTMAS.holidayPassed();
        Holiday.LABORDAY.holidayPassed();
        Holiday.NEWYER.holidayPassed();
    }

    public static int daysPerMonth2019(MonDay month) {

        switch (month) {
            case FEBRUARY:
                return 28;
            case APRIL:
                return 30;
            case JUNE:
                return 30;
            case SEPTEMBER:
                return 30;
            case NOVEMBER:
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
        int[] tmpArray = searchElementTwoDimensionalArray(array, searchNum);
        if (tmpArray[0] == -1) {
            return -1;
        }
        rez = rez * traverse(array, tmpArray[0], tmpArray[1], -1, -1);
        rez = rez * traverse(array, tmpArray[0], tmpArray[1], 1, 1);
        rez = rez * traverse(array, tmpArray[0], tmpArray[1], -1, 1);
        rez = rez * traverse(array, tmpArray[0], tmpArray[1], 1, -1);

        return rez;
    }

    public static int traverse(int[][] array, int i, int j, int stepI, int stepJ) {

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


    public static int[] searchElementTwoDimensionalArray(int[][] array, int searchNum) {
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


}
