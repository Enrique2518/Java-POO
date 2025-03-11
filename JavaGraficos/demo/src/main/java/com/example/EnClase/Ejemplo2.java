package com.example.EnClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ejemplo2 {

    public static void main(String[] args) {
        
        JFrame finestra = new JFrame("Example JDialog");
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());
        finestra.setLocation(200, 300);

        JButton botoObrir = new JButton("Obrir Dialeg");
        finestra.add(botoObrir);

        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialeg(finestra);
            }
        });

        finestra.setVisible(true);

    }

    private static void mostrarDialeg(JFrame parent){
        JDialog dialeg = new JDialog(parent, "Missatge important", true);
        dialeg.setSize(300, 150);
        dialeg.setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("Aixo es un dialeg!!", JLabel.CENTER);
        dialeg.add(etiqueta, BorderLayout.CENTER);

        JButton botoTancar = new JButton("D'acord");
        botoTancar.addActionListener(e -> dialeg.dispose());
        dialeg.add(botoTancar, BorderLayout.SOUTH);

        dialeg.setLocationRelativeTo(parent);
        dialeg.setVisible(true);

    }

}
