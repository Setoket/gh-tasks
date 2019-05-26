package tasks.stas.univer;

public class task01 {
    public static void main(String[] args) {
        Mydate mydate = new Mydate();
        System.out.print(mydate.month + " ");
        System.out.print(mydate.day + " ");
        System.out.print(mydate.year);
    }

    public static class Mydate {

        String month = "January";
        int day = 10;
        int year = 1997;
    }

    // this my exchanges!!!!!!!!!!!!!!!!!

}
