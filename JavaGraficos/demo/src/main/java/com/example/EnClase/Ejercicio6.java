package com.example.EnClase;

import javax.swing.*;
import java.awt.event.*;

public class Ejercicio6 {

    public static void main(String[] args) {
        // Crear el marc de la finestra
        JFrame frame = new JFrame("MouseListener Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JLabel
        JLabel label = new JLabel("Fuera", SwingConstants.CENTER);

        // Afegir un MouseListener per detectar quan el ratolí entra i surt del JLabel
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Dentro");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Fuera");
            }
        });

        // Afegir el JLabel al marc
        frame.add(label);

        // Fer visible el marc
        frame.setVisible(true);
    }

}
