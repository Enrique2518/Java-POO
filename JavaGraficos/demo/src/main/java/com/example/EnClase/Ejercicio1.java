package com.example.EnClase;

import javax.swing.*;

import java.awt.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        JFrame frame1 = new JFrame("CHAVARA Example");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.setBackground(Color.gray);
        panel1.add(new JLabel("File"));
        panel1.add(new JLabel("Options"));
        panel1.add(new JLabel("Help"));
        panel1.add(new JLabel("Proxy"));
        panel1.add(new JLabel("Cookies"));
        panel1.add(new JLabel("Accounts"));

        JPanel panel211 = new JPanel();
        panel211.setLayout(new GridLayout(5, 2));
        panel211.setBackground(Color.cyan);
        panel211.add(new JLabel("Account name: "));
        panel211.add(new JLabel("Full name: "));
        panel211.add(new JLabel("Password: "));
        panel211.add(new JLabel("Repeat Password: "));
        panel211.add(new JButton("Add"));

        JPanel panel212 = new JPanel();
        panel212.setLayout(new GridLayout(4, 2));
        panel212.setBackground(Color.cyan);
        panel212.add(new JTextField("Account name: "));
        panel212.add(new JTextField("Full name: "));
        panel212.add(new JTextField("Password: "));
        panel212.add(new JTextField("Repeat Password: "));

        JPanel panel21 = new JPanel();
        panel21.setBackground(Color.ORANGE);
        panel21.add(panel211);
        panel21.add(panel212);

        JPanel panelCuadrar = new JPanel();
        panelCuadrar.setBackground(Color.GRAY);
        panelCuadrar.setLayout(new BorderLayout());
        panelCuadrar.add(new JLabel("New user"), BorderLayout.NORTH);
        panelCuadrar.add(panel21, BorderLayout.SOUTH);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.MAGENTA);
        panel2.add(panelCuadrar);



        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 1));
        panel4.setBackground(Color.BLUE);
        panel4.add(new JLabel("OK"));
        panel4.add(new JLabel("Apply"));
        panel4.add(new JLabel("Cancel"));

        frame1.add(panel1, BorderLayout.NORTH);
        frame1.add(panel2, BorderLayout.CENTER);
        frame1.add(panel4, BorderLayout.PAGE_END);

        frame1.pack();

        frame1.setVisible(true);

    }

}
