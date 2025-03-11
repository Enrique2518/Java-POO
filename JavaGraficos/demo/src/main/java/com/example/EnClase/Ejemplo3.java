package com.example.EnClase;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejemplo3 {
    public static void main(String[] args) {
        
        JFrame frame1 = new JFrame("Ejemplo de JPanel");
        frame1.setSize(600, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setSize(200, 200);
        panel1.setBackground(Color.green);

        JButton b1 = new JButton("Haz Clic");
        panel1.add(b1);

        frame1.add(panel1);

        frame1.setVisible(true);

    }

}
