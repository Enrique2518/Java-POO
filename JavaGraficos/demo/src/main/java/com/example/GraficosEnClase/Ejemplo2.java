package com.example.GraficosEnClase;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejemplo2 extends JFrame{

    private JLabel etiquetaComptador;
    private int contador;
    private Timer timer;

    public Ejemplo2(){
        setTitle("Comptador");
        setDefaultCloseOperation(3);
        setSize(200, 100);
        setLayout(new FlowLayout());

        etiquetaComptador = new JLabel("0");
        etiquetaComptador.setFont(new Font("Arial", Font.BOLD, 24));
        add(etiquetaComptador);

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                etiquetaComptador.setText(String.valueOf(contador));
            }
            
        });

        timer.start();
        setVisible(true);

    }


    public static void main(String[] args) {
        
        new Ejemplo2();

    }

}
