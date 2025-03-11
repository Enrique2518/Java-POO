package com.example.EnClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ejercicio5 {

    public static void main(String[] args) {
        // Crear el JFrame principal
        JFrame frame = new JFrame("Ejemplo JCheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Crear el JCheckBox
        JCheckBox checkBox = new JCheckBox("Marcar para mostrar mensaje");

        // Añadir ItemListener al JCheckBox
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Verificar si el checkbox está seleccionado
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Mostrar JDialog cuando el checkbox está marcado
                    JOptionPane.showMessageDialog(frame, "¡El checkbox está marcado!", "Estado del Checkbox", JOptionPane.INFORMATION_MESSAGE);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    // Mostrar JDialog cuando el checkbox está desmarcado
                    JOptionPane.showMessageDialog(frame, "El checkbox está desmarcado.", "Estado del Checkbox", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Agregar el JCheckBox al JFrame
        frame.add(checkBox);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

