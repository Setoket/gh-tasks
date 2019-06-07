package Lab.Rab;

import java.util.Scanner;

public class Lab2v1v8 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter X: ");
        double x = in.nextDouble();
        System.out.println("Enter Y ");
        double y = in.nextDouble();
        System.out.println("Точка для проверки " + "(" + x + ";" + y + ")" + "\n" + "...");

        if (y >= x && y <= 1 && x >= -1 || y >= -x && y <= 1 && x <= 1){
            System.out.println("Точка попадает в область");
        }
        else{
            System.out.println("Точка не попадает в область");
        }
    }
}