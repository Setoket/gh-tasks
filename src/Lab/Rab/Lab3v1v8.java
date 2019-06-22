package Lab.Rab;

import java.util.Arrays;
import java.util.Scanner;

// Ярошенко С.Л. 173-331
// Лабораторная №2 Вариант 8 (Сортировка, сумма, произведение)
public class Lab3v1v8 {
    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        System.out.println("Заполните массив");
        int mas[] = new int[5];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = in.nextInt();
        }
        System.out.println("Сортируем элементы массива по возрастанию");
        Arrays.sort(mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

        int negativeSum = 0;
        int negativeProizved = 1;
        for (int i: mas) {
            if (i < 0){
                negativeSum += i;
                negativeProizved *= i;
            }
        }
        System.out.println("\n\n" + "Сумма отриц. элементов: " + negativeSum);
        System.out.println("\n" + "Произведение отриц. элементов: " + negativeProizved);
    }
}
