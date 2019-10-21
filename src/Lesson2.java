import java.util.Arrays;

public class Lesson2 {
    public static int dellIndex = 0;

    public static void main(String[] args) {

        System.out.println("Task 1");
        System.out.println(isPalindrome("asddasdd"));
        System.out.println(isPalindrome("asddaddsa"));
        System.out.println("Task 2");
        int[] array;
        array = isRandomArray(30);
        System.out.println(Arrays.toString(array));
        System.out.println("Task 3");
        System.out.println(isNumberOfPosition(array, 0));
        System.out.println("Task 4");
        System.out.println(Arrays.toString(isMinMaxElements(array)));
        System.out.println("Task 5");
        System.out.println(isArithmeticMean(array));
        System.out.println("Task 6");
        System.out.println(isSumNegativeElements(array));
        System.out.println("Task 7");
        array = isDeleteArrayElement(array, 5);
        System.out.println(Arrays.toString(array));
        System.out.println("Task 8");
        System.out.println(Arrays.toString(isReverseArray(array)));
        System.out.println("Task 9");
        System.out.println(isSortedInAscendingOrder(array));
        int[] testArray = {-1, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(isSortedInAscendingOrder(testArray));
        System.out.println("Task 10");
        //все оказалось просто
        System.out.println(Arrays.toString(isRandomSortedArray(array)));
        System.out.println("Task 11 Пузырьком, как заказывали:)");
        System.out.println(Arrays.toString(isArrSorting(array)));
        System.out.println("Task 12");
        isTwoDimensionalRandomArray(10, 10);

    }

    public static Boolean isPalindrome(String s) {
        if (s.equals((new StringBuilder(s)).reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] isRandomArray(int numElemets) {
        int max = 100;
        int min = -100;
        max -= min;
        int[] arrays = new int[numElemets];
        for (int i = 0; i < numElemets; i++) {
            arrays[i] = (int) (Math.random() * ++max) + min;
        }
        return arrays;
    }

    public static int isNumberOfPosition(int[] arrays, int searchNumber) {

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == searchNumber) {
                return i;
            }
        }
        return -1;
    }

    public static int[] isMinMaxElements(int[] arrays) {
        int minElement = arrays[0];
        int minIndex = 0;
        int maxElement = arrays[0];
        int maxIndex = 0;

        for (int i = 1; i < arrays.length || arrays.length <= 1; i++) {
            if (minElement > arrays[i]) {
                minIndex = i;
                minElement = arrays[i];
            }
            if (maxElement < arrays[i]) {
                maxIndex = i;
                maxElement = arrays[i];
            }
        }
        arrays[minIndex] = maxElement;
        arrays[maxIndex] = minElement;
        return arrays;
    }

    public static double isArithmeticMean(int[] arrays) {
        double arithmeticmean = 0;
        for (int i = 0; i < arrays.length; i++) {
            arithmeticmean = arithmeticmean + arrays[i];
        }
        return arithmeticmean / arrays.length;
    }

    public static int isSumNegativeElements(int[] arrays) {
        int sumNegativeElements = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < 0) {
                sumNegativeElements++;
            }
        }
        return sumNegativeElements;
    }

    public static int[] isDeleteArrayElement(int[] arrays, int deletePosition) {
        int[] arraysRez = new int[arrays.length - 1];
        int j = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (i == deletePosition) {
                i++;
            }
            if (i < arrays.length) {
                arraysRez[j] = arrays[i];
                j++;
            }
        }
        return arraysRez;
    }

    public static int[] isReverseArray(int[] array) {
        int[] arraryReverse = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++) {
            arraryReverse[j] = array[i];
            j--;
        }
        return arraryReverse;
    }

    public static boolean isSortedInAscendingOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }

    public static int[] isRandomSortedArray(int[] array) {

        int randomIndex;

        int[] arrayResult = new int[array.length];
        for (int i = 0; i < arrayResult.length; i++) {
            randomIndex = (int) (Math.random() * (array.length - 1));
            arrayResult[i] = array[randomIndex];
            array = isDeleteArrayElement(array, randomIndex);
        }
        return arrayResult;
    }


    public static int[] isArrSorting(int[] array) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = isMinElementArray(array);
            array = isDeleteArrayElement(array, dellIndex);
            dellIndex = 0;
        }
        return resultArray;
    }

    public static int isMinElementArray(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                dellIndex = i;
            }
        }
        return min;
    }

    public static void isTwoDimensionalRandomArray(int n, int m) {
        int max = 100;
        int min = -100;
        max -= min;
        int[][] arrays = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrays[i][j] = (int) (Math.random() * ++max) + min;
                System.out.print(arrays[i][j] + " ");
                if (j == (m - 1)) System.out.println();
            }
        }


    }


}


