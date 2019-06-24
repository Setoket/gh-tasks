package Lab.Rab;
import java.io.*;
import java.util.Scanner;
// Ярошенко С.Л. 173-331
// Лабораторная №3 Вариант 14 (Сдвиг матрицы)

public class Lab3v2v14 {
    public static void main(String[] args)
    {
        int spiral[][];
        int Step;
        int cur[], shift[];
        int N, k, c, edge;
        //try нужен для того, чтобы при возниковении исключения, программа говорила нам об этом и не могла зайти в код.

        try{
            Scanner sc = new Scanner(new File("matrix.txt"));
            Scanner in = new Scanner(System.in);
            System.out.println("Введите размерность матрицы из файла matrix.txt");
            System.out.print("Строк: ");
            N=in.nextInt();
            cur= new int[4 * (N - 1)];
            shift= new int[4 * (N - 1)];
            spiral = new int[N][N];
            //цикл заполнения массива из файла
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    spiral[i][j] = sc.nextInt();
                }
            }
            System.out.println("Матрица из файла matrix.txt:\n");
            //Вывод матрицы с файла matrix.txt
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    System.out.print(spiral[i][j]+"    ");
                }
                if (i<i+1)
                    System.out.println("\n");
            }

            System.out.println("На сколько циклов сделать сдвиг? ");
            Step = in.nextInt();
            //Процедура спирального сдвига матрицы
            for (k = 0; k < N / 2; k++) //слои
            {
                edge = N - 1 - k;
                //снять слой
                c = 0;

                for (int j = k; j < edge; j++)
                {
                    cur[c] = spiral[k][j];
                    c++;
                }

                for (int i = k; i < edge; i++)
                {
                    cur[c] = spiral[i][edge];
                    c++;
                }

                for (int j = edge; j >= k; j--)
                {
                    cur[c] = spiral[edge][j];
                    c++;
                }

                for (int i = edge - 1; i > k; i--)
                {
                    cur[c] = spiral[i][k];
                    c++;
                }

                //переставить
                for (int i = 0; i < 4 * (N - 2 * k - 1); i++)
                    shift[(i + Step) % (4 * (N - 2 * k - 1))] = cur[i];

                //одеть слой
                c = 0;

                for (int j = k; j < edge; j++)
                {
                    spiral[k][j] = shift[c];
                    c++;
                }

                for (int i = k; i < edge; i++)
                {
                    spiral[i][edge] = shift[c];
                    c++;
                }

                for (int j = edge; j >= k; j--)
                {
                    spiral[edge][j] = shift[c];
                    c++;
                }

                for (int i = edge - 1; i > k; i--)
                {
                    spiral[i][k] = shift[c];
                    c++;
                }
            }

            System.out.println("Сдвинутая матрица: \n");
            //Цикл вывода сдвинутой матрицы
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    System.out.print(spiral[i][j]+"    ");
                }
                if (i<i+1)
                    System.out.println("\n");
            }
        }

        //Если программа не сможет найти файл, то выведется исключение типа FileNotFoundException
        catch(FileNotFoundException ex){
            System.out.print(ex.toString());
        }
    }

}
