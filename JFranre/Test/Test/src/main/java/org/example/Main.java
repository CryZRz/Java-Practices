package org.example;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        var imageIcon = new ImageIcon("/home/christian/Documentos/Java/JFranre/Test/Test/src/main/java/org/example/golang.png");
        var border = BorderFactory.createLineBorder(Color.black, 3);

        var label = new JLabel(); //Create label
        label.setText("Bro, do you even code"); //set text of label
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LFET,CENTER, RIGHT of imageicon
        //label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CENTER, BOTTOM, of imageicon
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(100); //set gap of text to image
        label.setBackground(Color.CYAN);
        label.setOpaque(true); //display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icontext within label
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100, 100,350, 350);//set x,y position within frame as well as dimensions

        JFrame window = new JFrame("Hello world");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //window.setSize(400, 250);
        //window.setLayout(null);
        window.setVisible(true);
        window.add(label);
        window.pack();
    }
}