package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //JPLANE a GUI component that functions as a container to hold other components

        var iamgenIcon = new ImageIcon("/home/christian/Documentos/Java/JFranre/Test/Test/src/main/java/org/example/golang.png");

        var label = new JLabel();
        label.setText("Hi");
        label.setIcon(iamgenIcon);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.RIGHT);

        var grennPanel = new JPanel();
        grennPanel.setBackground(Color.GREEN);
        grennPanel.setBounds(0, 0, 250, 250);

        var bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250, 0, 250, 250);

        var redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 250, 500, 250);
        redPanel.setLayout(new BorderLayout());

        var window = new JFrame("Jimena");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(750, 750);
        window.setVisible(true);
        redPanel.add(label);
        window.add(grennPanel);
        window.add(bluePanel);
        window.add(redPanel);
    }
}