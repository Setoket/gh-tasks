package Lab.Rab.LabGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Lab3v1 extends JFrame {
    private int mas[] = new int[5];
    int negativeSum = 0;
    int negativeProizved = 1;
    private JLabel labe0 = new JLabel("Заполните массив");
    private JLabel label = new JLabel();
    private JButton button = new JButton("Выполнить");
    private JTextField input1 = new JTextField();
    private JTextField input2 = new JTextField();
    private JTextField input3 = new JTextField();
    private JTextField input4 = new JTextField();
    private JTextField input5 = new JTextField();
    private JLabel label1 = new JLabel("1-ый элемент:");
    private JLabel label2 = new JLabel("2-ый элемент:");
    private JLabel label3 = new JLabel("3-ый элемент:");
    private JLabel label4 = new JLabel("4-ый элемент:");
    private JLabel label5 = new JLabel("5-ый элемент:");
    private JLabel ResultName = new JLabel("Сортируем по возрастанию:");
    private JLabel Result = new JLabel();
    private JLabel ResultName2 = new JLabel("Сумма отрицательных элементов");
    private JLabel Result2 = new JLabel();
    private JLabel ResultName3 = new JLabel("Произведение отрицательных элементов");
    private JLabel Result3 = new JLabel();


    public Lab3v1() {
        super("Laba #3v1 GUI");
        this.setBounds(200, 200, 600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 2, 2, 2));
        container.add(labe0); // Заполните массив
        container.add(label); // Пустой блок
        container.add(label1);// 1-ый элемент
        container.add(input1);// Ввод 1-ый элемент
        container.add(label2);// 2-ый элемент
        container.add(input2);// Ввод 2-ый элемент
        container.add(label3);// 3-ый элемент
        container.add(input3);// Ввод 3-ый элемент
        container.add(label4);// 4-ый элемент
        container.add(input4);// Ввод 4-ый элемент
        container.add(label5);// 5-ый элемент
        container.add(input5);// Ввод 5-ый элемент
        container.add(ResultName);
        container.add(Result);
        container.add(ResultName2);
        container.add(Result2);
        container.add(ResultName3);
        container.add(Result3);
        container.add(button);

        button.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mas[0] = Integer.parseInt(input1.getText());
            mas[1] = Integer.parseInt(input2.getText());
            mas[2] = Integer.parseInt(input3.getText());
            mas[3] = Integer.parseInt(input4.getText());
            mas[4] = Integer.parseInt(input5.getText());


            for (int i = 0; i < mas.length; i++) {
             Arrays.sort(mas);
                Result.setText(mas[0] + " " + mas[1] + " " + mas[2] + " " + mas[3] + " " + mas[4]);
            }

            for (int i: mas) {
                if (i < 0){
                    negativeSum += i;
                    negativeProizved *= i;

                    Result2.setText(Integer.toString(negativeSum));
                    Result3.setText(Integer.toString(negativeProizved));
                }

                if (mas [0] >= 0 && mas[1] >= 0 && mas[2] >= 0 && mas[3] >= 0 && mas[4] >= 0 ){
                    Result2.setText("Отрицательных чисел нет");
                    Result3.setText("Отрицательных чисел нет");
                }
            }
        }
    }
}


