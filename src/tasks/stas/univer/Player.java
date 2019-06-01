package tasks.stas.univer;

public class Player {
    int number = 0;     // Here хранится вариант числа
    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("Думаю, это число " + number);
    }
}
