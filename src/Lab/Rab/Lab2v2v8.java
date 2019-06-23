package Lab.Rab;
// Ярошенко С.Л. 173-331
// Лабораторная №2 Вариант 8 (Проверка убывающией последовательности)
import java.util.Scanner;

public class Lab2v2v8 {
        public static void main(String[] agrs) {
            int result = 0; //Атрибут Убывания\Возрастания 1 или 0
            Scanner in = new Scanner(System.in);
            System.out.println("Введите последовательность чисел, 0 - конец последовательности");
            int mas[] = new int[5];

            for (int i = 0; i < mas.length; i++) {
                System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
                mas[i] = in.nextInt();
            }
            if (mas[mas.length-1] != 0) {
                System.out.println("Концом последовательности должен быть - 0");
            }

            else {
             //-------------Алгоритм проверки убывания последовательности
                System.out.println("Проверяем последовательность");
                for (int i = 1; i < mas.length; i++) {
                    if (mas[i-1] > mas[i]) {
                        result = 1;
                    }
                    else {
                        result = 0;
                        break;
                    }
                }
                System.out.println("Код последовательности: " + result);
            }
            //-------------Конец алгоритма

        }
}
