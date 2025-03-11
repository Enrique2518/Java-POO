package com.example.EnClase;

import javax.swing.*;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Ventana");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hola mundo");
        JButton btton1 = new JButton("Hola soy yo");

        frame.getContentPane().add(btton1);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        


    }
    
}

