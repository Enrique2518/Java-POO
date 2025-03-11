package com.example.EnClase;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Ejemplo de JSlider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Crear un JSlider con un rango de 0 a 100
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // (orientación, mínimo, máximo, valor inicial)
        
        // Establecer que el JSlider es editable
        slider.setMajorTickSpacing(20); // Espaciado de las principales marcas
        slider.setMinorTickSpacing(5);  // Espaciado de las marcas menores
        slider.setPaintTicks(true);     // Pintar las marcas
        slider.setPaintLabels(true);   // Pintar los valores de las marcas
        
        // Crear un JLabel para mostrar el valor del slider
        JLabel label = new JLabel("Valor: " + slider.getValue());
        
        // Añadir un ChangeListener para actualizar el JLabel cuando el valor del slider cambie
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("Valor: " + slider.getValue());
            }
        });
        
        // Crear un panel para agregar el slider y la etiqueta
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(slider, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);
        
        // Añadir el panel a la ventana
        frame.add(panel);
        
        // Hacer visible la ventana
        frame.setVisible(true);

    }

}
