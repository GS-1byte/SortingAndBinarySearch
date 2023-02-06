import java.util.Scanner;

import static library.Sorting.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Сортировка слиянием. \nВведите длину массива: ");
        int number = input.nextInt();
        for (int item : mergeSort(randomArray(number, 100, 10))) {
            System.out.printf("[%d] ", item);
        }

        System.out.print("\nСортировка подсчетом. \nВведите длину массива: ");
        number = input.nextInt();
        for (int item : sortingByCounting(number)) {
            System.out.printf("[%d] ", item);
        }

        System.out.print("\nC точки зрения Димы, если ноутбуки будут отсортированы по возрастанию цены," +
                "\n то они также будут отсортированы по качеству. Проверим утверждение Димы.\nВведите кол-во ноутбуков: ");
        number = input.nextInt();
        System.out.println(compareIncrease(number));
    }
}