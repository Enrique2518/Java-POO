package com.example.EnClase;

import javax.swing.*;
import java.awt.event.*;

public class Ejercicio7 {

    public static void main(String[] args) {
        // Crear el marc de la finestra
        JFrame frame = new JFrame("KeyListener Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un JTextField per que l'usuari escrigui
        JTextField textField = new JTextField(20);
        
        // Crear un JLabel per mostrar el contador
        JLabel label = new JLabel("Contador: 0", SwingConstants.CENTER);
        
        // Afegir un KeyListener al JTextField
        textField.addKeyListener(new KeyAdapter() {
            int contador = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                // Comprovem si la tecla pressionada és 'a' o 'A'
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    contador++; // Sumar 1 al contador
                    label.setText("Contador: " + contador); // Actualitzar el text del JLabel
                }
            }
        });

        // Afegir el JTextField i el JLabel al marc
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(label);
        
        frame.add(panel);

        // Fer visible el marc
        frame.setVisible(true);
    }

}
