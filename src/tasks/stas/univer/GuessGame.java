package tasks.stas.univer;

public class GuessGame {            // GuessGame содержит three переменных экземпляра for three объектов Player
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){        // Создаем three объекта Player и присваиваем их трем переменным экземпляра
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;            // Объявляем three переменные для хранения вариантов каждого игрока
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isRight = false;  // Объявляем three переменные для хранения true or false the answers игроков
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);  // Create the number, которое игроки должны guess
        System.out.println("Я загадываю число от 0 до 9...");

        while (true) {
            System.out.println("Число, которое нужно угадать, - " + targetNumber);

            p1.guess();             // Вызываем метод guess() из каждого объекта Player
            p2.guess();
            p3.guess();

            guessp1 = p1.number;    // Извлекаем варианты каждого игрока ( the work results их методов guess()
            System.out.println("Первый игрок думает, что это " + guessp1);  // Получая доступ к их переменным number

            guessp2 = p2.number;
            System.out.println("Второй игрок думает, что это " + guessp2);

            guessp3 = p3.number;
            System.out.println("Третий игрок думает, что это " + guessp3);

            if (guessp1 == targetNumber) {  // Check варианты каждого из игроков на соответствие загаданному числу.
                p1isRight = true;           // If игрок guess, то присваиваем соответствующей переменной значение true.
            }                               // По умолчание она хранит значение False (см. строку 17-19)
            if (guessp2 == targetNumber){
                p2isRight = true;
            }
            if (guessp3 == targetNumber){
                p3isRight = true;
            }

            if (p1isRight || p2isRight || p3isRight){   // If кто то из игроков угадал, то.. (оператор || означает ИЛИ)

                System.out.println("У нас есть победитель");
                System.out.println("Первый игрок угадал?" + p1isRight);
                System.out.println("Первый игрок угадал?" + p2isRight);
                System.out.println("Первый игрок угадал?" + p3isRight);
            }
            else {
                System.out.println("Игроки должны попробовать еще раз");
            }
        }
    }
}
