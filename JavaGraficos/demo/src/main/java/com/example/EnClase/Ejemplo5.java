package com.example.EnClase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ejemplo5 {

    public static void main(String[] args) {
        
        JFrame finestra = new JFrame("Exemple Swing");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(300, 150);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));

        JTextField campText = new JTextField(15);
        panel1.add(campText);

        JLabel etiqueta = new JLabel("Aqui ira el texto");
        panel1.add(etiqueta);

        JButton boton = new JButton("Mostrar el texto");
        panel1.add(boton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText(campText.getText());
            }
        });

        finestra.add(panel1);
        finestra.setVisible(true);

    }

}
