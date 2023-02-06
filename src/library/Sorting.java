package library;

import java.util.Arrays;

public class Sorting {

    // Первая задача
    public static int[] mergeSort(int[] sortArray){
        if (sortArray.length == 1)
            return sortArray;
        else{
            int divLength = (sortArray.length + 1)/ 2;
            int[] firstPart = new int[divLength];
            int[] secondPart = new int[sortArray.length - firstPart.length];

            for (int i = 0; i < firstPart.length; i++) {
                firstPart[i] = sortArray[i];
                if (i < secondPart.length)
                    secondPart[i] = sortArray[divLength + i];
            }

            return mergeArray(mergeSort(firstPart), mergeSort(secondPart));
        }
    }
    private static int [] mergeArray(int[] firstArray, int[] secondArray){
        int[] resultArray = new int [(firstArray.length + secondArray.length)];
        for (int f = 0, s = 0, i = 0; i < resultArray.length; i++) {
            if (firstArray.length > f && secondArray.length > s){
                if (firstArray[f] > secondArray[s]) {
                    resultArray[i] = secondArray[s];
                    s++;
                }
                else {
                    resultArray[i] = firstArray[f];
                    f++;
                }
            }
            else if (firstArray.length <= f){
                resultArray[i] = secondArray[s];
                s++;
            }
            else {
                resultArray[i] = firstArray[f];
                f++;
            }
        }
        return resultArray;
    }

    //Вторая задача
    public static int[] sortingByCounting(int arrayLength){
        int[] array = randomArray(arrayLength, 10, 1);
        int max = maxValue(array);
        int min = minValue(array);

        int new_i = 0;
        for (int j = min; j <= max; j++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == j){
                    array[new_i] = array[i];
                    new_i++;
                }
            }
        }
        return array;
    }

    private static int maxValue(int[] array){
        int max_i = array[0];
        for (int i : array) {
            if (i > max_i)
                max_i = i;
        }
        return max_i;
    }
    private static int minValue(int[] array){
        int min_i = array[0];
        for (int i : array) {
            if (i < min_i)
                min_i = i;
        }
        return min_i;
    }

    //Третья задача
    public static String compareIncrease (int quantity){
        int[] cost = randomArray(quantity, 1000, 100);
        int[] quality = randomArray(quantity, 20, 1);

        Arrays.sort(cost);
        Arrays.sort(quality);
        String message = "Утверждение Димы верно";

        for (int i = 1; i < cost.length; i++) {
            if ((cost[i] > cost[i - 1] && quality[i] <= quality [i - 1]) || (cost[i] == cost[i - 1] && quality[i] > quality [i - 1])){
                message = "Утверждение Димы не верно";
            }
        }
        return message;
    }


    /**
     * Метод создает массив случайных натуральных чисел ограниченных диапозоном от minValue до maxValue.
     * @param arrayLength длина массива
     * @param maxValue максимальное число
     * @param minValue минимальное число
     * @return массив натуральных чисел
     */
    public static int[] randomArray (int arrayLength, int maxValue, int minValue){
        int[] array = new int[arrayLength];
        int dif = maxValue - minValue;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * dif) + minValue;
        }
        return array;
    }
}
