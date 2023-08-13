package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    protected JButton button;
    protected  JLabel label;
    protected boolean visible = false;

    public MyFrame(){
        super("Zaida");

        var imageIcon = new ImageIcon("/home/christian/Documentos/Java/JFranre/Test/Test/src/main/java/org/example/golang.png");
        var imageIcon2 = new ImageIcon("/home/christian/Documentos/Java/JFranre/Test/Test/src/main/java/org/example/zaida.jpg");

        this.label = new JLabel();
        this.label.setIcon(imageIcon2);
        this.label.setBounds(250, 100, 500, 500);
        this.label.setVisible(this.visible);

        this.button = new JButton("my button");
        button.setBounds(200, 100, 150, 250);
        button.setFocusable(false);
        button.setIcon(imageIcon);

        button.addActionListener(e -> {
            System.out.println("Zaida");
            this.visible = !this.visible;
            this.label.setVisible(this.visible);
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    //only work implements ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button){
            System.out.println("Zaida");
            this.label.setVisible(true);
        }
    }
}
