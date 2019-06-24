package Lab.Rab.LabGUI;

import  java.awt.*;
import  java.awt.event.*;
import  javax.swing.*;

public class SimpleGUI extends JFrame {
    private float x;
    private float y;

    String message;
    private  JButton button = new JButton("Press");
    private  JTextField inputX = new JTextField();
    private  JTextField inputY = new JTextField();
    private  JLabel labelX = new JLabel(" Input X:");
    private  JLabel labelY = new JLabel(" Input Y:");
    private  JLabel labelResult = new JLabel(" Point for calculate:"+"("+x+";"+y+")");
    private  JLabel labelResult2 = new JLabel(message);



    public  SimpleGUI () {
        super("Laba #2v1 GUI");
        this.setBounds(200, 200, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane(); // Дефолтный код, выделяет область в JFrame
        container.setLayout(new GridLayout(4, 2,2,2));//размеченая панель из 4 строк и 2 столбцов
        container.add(labelX);//1я ячейка 1й строки
        container.add(inputX);//2я ячейка 1й строки
        container.add(labelY);//1я ячейка 2й строки
        container.add(inputY);//2я ячейка 2й строки
        container.add(labelResult);//1я ячейка 3й строки
        container.add(labelResult2);//2я ячейка 3й строки
        container.add(button);//1я ячейка 4й строки

        button.addActionListener(new ButtonEventListener());


    }

    //Добавляем listener (обработчик действий) для кнопки button
   class ButtonEventListener implements ActionListener {
            public void actionPerformed (ActionEvent e) {
               x=Float.parseFloat(inputX.getText()); // Конвертер в Float. Далее ввод данных с клавиатуры в поля
               y=Float.parseFloat(inputY.getText());

                if (y >= x && y <= 1 && x >= -1 || y >= -x && y <= 1 && x <= 1){
                    message ="Точка попадает в область";
                }
                else {
                    message ="Точка не попадает в область";
                }
                labelResult2.setText(message);
                labelResult.setText(" Point for calculate:"+"("+x+";"+y+")");
            }
        }
}

