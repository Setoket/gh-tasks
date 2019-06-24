package Lab.Rab.LabGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2v2 extends JFrame {
    private int mas[] = new int[5];
    private int result;
    String message;
    private JLabel labe0 = new JLabel("Введите последовательность чисел");
    private JLabel label = new JLabel("0 - конец последовательности");
    private JButton button = new JButton("Проверить");
    private JTextField input1 = new JTextField();
    private JTextField input2 = new JTextField();
    private JTextField input3 = new JTextField();
    private JTextField input4 = new JTextField();
    private JTextField input5 = new JTextField();
    private JLabel label1 = new JLabel("Первое число:");
    private JLabel label2 = new JLabel("Второе число:");
    private JLabel label3 = new JLabel("Третье число:");
    private JLabel label4 = new JLabel("Четвертое число:");
    private JLabel label5 = new JLabel("Пятое число:");
    private JLabel labelResult = new JLabel(" Код последовательности:" + result);
    private JLabel labelResult2 = new JLabel(message);

    public Lab2v2() {
        super("Laba #2v1 GUI");
        this.setBounds(200, 200, 600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8, 2, 2, 2));
        container.add(labe0);
        container.add(label);
        container.add(label1);
        container.add(input1);
        container.add(label2);
        container.add(input2);
        container.add(label3);
        container.add(input3);
        container.add(label4);
        container.add(input4);
        container.add(label5);
        container.add(input5);
        container.add(labelResult);
        container.add(labelResult2);
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
            }
            if (mas[mas.length - 1] != 0) {
                String s = "Концом последовательности должен быть - 0";
                labelResult2.setText(s);
            } else {

                //-------------Алгоритм проверки убывания последовательности
                for (int i = 1; i < mas.length; i++) {
                    if (mas[i - 1] > mas[i]) {
                        result = 1;
                    } else {
                        result = 0;
                        break;
                    }
                }
                labelResult2.setText(Integer.toString(result));

            }
        }
    }
}

