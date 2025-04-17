package com.example.PongJuego;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

        String jugador1Nombre = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1:");
        String jugador2Nombre = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2:");

         // Si no ingresan nombres, asignamos nombres por defecto
         if (jugador1Nombre == null || jugador1Nombre.trim().isEmpty()) {
            jugador1Nombre = "Jugador 1";
        }
        if (jugador2Nombre == null || jugador2Nombre.trim().isEmpty()) {
            jugador2Nombre = "Jugador 2";
        }

        JFrame frame = new JFrame("Cercle Rebotant"); // Crea la finestra
        CercleRebotant panel = new CercleRebotant(jugador1Nombre, jugador2Nombre); // Crea una instància del panell
        frame.setResizable(false);
        frame.add(panel); // Afegeix el panell a la finestra
        frame.setSize(1016, 638); // Defineix la mida de la finestra
        //Se le suma 16 de anchho y 38 de alto en px porque son lo que le sobran para que nuestro panel tenga
        //un ancho de 1000 y un alto de 600
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el tancament de la finestra
        frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla
        frame.setVisible(true); // Mostra la finestra
    }
    
    

}
