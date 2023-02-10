import java.util.Scanner;

import static library.Sorting.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        /*System.out.print("Сортировка слиянием. \nВведите длину массива: ");
        number = input.nextInt();
        for (int item : mergeSort(randomArray(number, 100, 10))) {
            System.out.printf("[%d] ", item);
        }

        System.out.print("\nСортировка подсчетом. \nВведите длину массива: ");
        number = input.nextInt();
        for (int item : sortingByCounting(randomArray(number, 10, 1))) {
            System.out.printf("[%d] ", item);
        }

        System.out.print("\nC точки зрения Димы, если ноутбуки будут отсортированы по возрастанию цены," +
                "\n то они также будут отсортированы по качеству. Проверим утверждение Димы.\nВведите кол-во ноутбуков: ");
        number = input.nextInt();
        System.out.println(compareIncrease(number));*/

        System.out.print("\nБинарный поиск. \nВведите число для поиска в массиве от 1 до 20: ");
        number = input.nextInt();
        System.out.println(binarySearch(sortingByCounting(randomArray(10, 20, 1)), number));
        System.out.println(approxBinarySearch(sortingByCounting(randomArray(10, 20, 1)), number));
    }
}