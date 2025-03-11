package com.example.EnClase;

import javax.swing.*;
import java.awt.*;

public class Ejemplo4 {

    public static void main(String[] args) {
        
        JFrame finestra = new JFrame("Exemple amb Lyout");
        finestra.setSize(500, 300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setLayout(new GridLayout(2, 20));
        panel.add(new JButton("Boto 1"));
        panel.add(new JButton("Boto 2"));
        panel.add(new JButton("Boto 3"));


        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.green);
        panelCentral.setLayout(new GridLayout(3,3));
        panelCentral.add(new JLabel("Etiqueta 1"));
        panelCentral.add(new JTextField("Texto 1:"));
        panelCentral.add(new JLabel("Etiqueta 2"));
        panelCentral.add(new JTextField("Texto 2:"));

        finestra.add(panel, BorderLayout.NORTH);
        finestra.add(panelCentral, BorderLayout.CENTER);

        finestra.setVisible(true);

    }

}
