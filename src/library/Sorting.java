package library;

import java.util.Arrays;
import java.util.Scanner;

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
    public static int[] sortingByCounting(int[] array){
        int[] newArray = new int[array.length];
        int max = maxValue(array);
        int min = minValue(array);

        int new_i = 0;
        for (int j = min; j <= max; j++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == j){
                    newArray[new_i] = array[i];
                    new_i++;
                }
            }
        }
        return newArray;
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

    //Четвертая задача
    public static String binarySearch (int[] array, int desNum){
        int left = -1;
        int right = array.length;
        String messege = "Число " + desNum;
        while ((right - left) > 1){
            int mid = (right + left)/2;
            if (array[mid] == desNum) {
                messege += " найдено в массиве под индексом" + mid;
                return messege;
            }
            else if (array[mid] > desNum)
                right = mid;
            else
                left = mid;
        }
        if (array[right - left] == desNum)
            messege += " найдено в массиве под индексом" + (right - left);
        else
            messege += " не найдено";
        return messege;
    }

    //Пятая задача
    public static String approxBinarySearch (int[] array, int desNum){
        int left = -1;
        int right = array.length;
        String messege = "Ближайшее число в массиве к " + desNum + " равно ";
        while ((right - left) > 1){
            int mid = (right + left)/2;
            if (array[mid] == desNum){
                messege += array[mid];
                return messege;
            }
            else if (array[mid] > desNum)
                right = mid;
            else
                left = mid;
        }
        if (left < 0)
            messege += array[right];
        else if (right >= array.length || desNum - array[left] < array[right] - desNum)
            messege += array[left];
        else
            messege += array[right];
        return messege;
    }

    //Шестая задача
    public static void guessMyNumber(){
        Scanner input = new Scanner(System.in);
        int left = 0;
        int right = (int)Math.pow(10,6) + 1;
        String answer;
        while ((right - left) > 1){
            int mid = (right + left)/2;
            System.out.println("Ваше число больше или меньше " + mid + "?");
            answer = input.next();
            if (answer.equals(">")){
                left = mid;
            } else if (answer.equals("<")) {
                right = mid;
            } else if (answer.equals("=")){
                System.out.println("Загаданное число " + mid);
                break;
            }
        }
        System.out.println("Загаданное число " + (left));
    }

    //Седьмая задача
    public static int solution(int value){
        int left = 0;
        int right = (int)Math.pow(10,5);
        while ((right-left) > 1){
            int mid = (right + left)/2;
            if(func(mid, value) < 0)
                left = mid;
            else if (func(mid, value) > 0)
                right = mid;
            else
                return mid;
        }
        return 0;
    }
    private static double func(int x, int c){
        return Math.pow(x, 2) + Math.pow(x, 0.5) - c;
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
