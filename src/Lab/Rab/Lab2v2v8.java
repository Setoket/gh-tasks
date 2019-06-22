package Lab.Rab;
// Ярошенко С.Л. 173-331
// Лабораторная №2 Вариант 8 (Проверка убывающией последовательности)
import java.util.Scanner;

public class Lab2v2v8 {
        public static void main(String[] agrs) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите последовательность чисел, 0 - конец последовательности");
            int mas[] = new int[5];

            for (int i = 0; i < mas.length; i++) {
                mas[i] = in.nextInt();
            }

            if (mas[4] != 0) {
                System.out.println("Концом последовательности должен быть - 0");
            }

            else {
                System.out.println("Проверяем последовательность");
                for (int i = 0; i < mas.length; i++) {
                    System.out.print(mas[i] + " ");// Выводим заполненый массив на экран
                }
            }
        }
}
