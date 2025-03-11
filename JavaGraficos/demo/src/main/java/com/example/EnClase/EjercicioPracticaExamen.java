package com.example.EnClase;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EjercicioPracticaExamen {

    public static void main(String[] args) {

        String generos[] = {"Accion", "Comedia", "Drama", "Terror", "Ciencia Ficcion"};
        String vocales[] = {"A", "E", "I", "O", "U"};
        
        JFrame frame1 = new JFrame("Ficha de pelicula.");
        frame1.setLayout(new GridLayout(9, 2));
        frame1.setSize(400, 400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel 1
        JLabel tituloPeli = new JLabel("Titulo de la película: ");
        JTextField peli = new JTextField(10);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(tituloPeli, BorderLayout.WEST);
        panel1.add(peli, BorderLayout.EAST);

        //Panel2
        JLabel GeneroPeli = new JLabel("Genero: ");
        JComboBox<String> genero = new JComboBox<>(generos);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(GeneroPeli, BorderLayout.WEST);
        panel2.add(genero, BorderLayout.EAST);

        //Panel3
        JLabel anyoEstreno = new JLabel("Año de estreno: ");
        JSlider anyo = new JSlider(0,1900, 2025, 2000);
        anyo.setMajorTickSpacing(25);
        anyo.setMinorTickSpacing(5);
        anyo.setPaintTicks(true);
        anyo.setPaintLabels(true);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(anyoEstreno, BorderLayout.WEST);
        panel3.add(anyo, BorderLayout.EAST);

        //Panel4
        JLabel anyoSeleccionado = new JLabel("Año seleccionado: ");
        JLabel anyoSel = new JLabel("");

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.add(anyoSeleccionado, BorderLayout.WEST);
        panel4.add(anyoSel, BorderLayout.CENTER);

        //Panel5
        JButton mostrarFicha = new JButton("Mostrar ficha");
        JLabel resultadoFicha = new JLabel("");

        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        panel5.add(mostrarFicha, BorderLayout.NORTH);
        panel5.add(resultadoFicha, BorderLayout.SOUTH);

        //Panel6
        JLabel seleccVocal = new JLabel("Selecciona una vocal: ");
        JComboBox<String> vocal = new JComboBox<>(vocales);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        panel6.add(seleccVocal, BorderLayout.WEST);
        panel6.add(vocal, BorderLayout.EAST);

        //Panel7
        JButton mostrarVocales = new JButton("Contar Vocales");
        JLabel resultadoVocales = new JLabel("");

        JPanel panel7 = new JPanel();
        panel7.setLayout(new BorderLayout());
        panel7.add(mostrarVocales, BorderLayout.NORTH);
        panel7.add(resultadoVocales, BorderLayout.SOUTH);

        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(panel3);
        frame1.add(panel4);
        frame1.add(panel5);
        frame1.add(panel6);
        frame1.add(panel7);

        frame1.setVisible(true);

        anyo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                anyoSel.setText("Valor: " + anyo.getValue());
            }
        });

        genero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generoSel = (String)genero.getSelectedItem();
                if ("Terror".equals(generoSel)) {
                    JOptionPane.showMessageDialog(frame1, "Has seleccionado la pelicula terror.");
                }
            }
            
        });

        mostrarFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String defPelicula = peli.getText();
                String valorGeneroPelicula = "";
                int genPelicula = genero.getSelectedIndex();
                switch (genPelicula) {
                    case 0:
                        valorGeneroPelicula = "Accion";
                        break;

                        case 1:
                        valorGeneroPelicula = "Comedia";
                        break;

                        case 2:
                        valorGeneroPelicula = "Drama";
                        break;

                        case 3:
                        valorGeneroPelicula = "Terror";
                        break;

                        case 4:
                        valorGeneroPelicula = "Ciencia Ficcion";
                        break;
                
                    default:
                        break;
                }
                String anPelicula = anyoSel.getText();
                resultadoFicha.setText("Pelicula: " + defPelicula + "| Genero: " + valorGeneroPelicula + "| Año: " + anPelicula);
            }
            
        });

        genero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = 4;
                if (genero.getSelectedIndex() == numero) {
                    
                }
            }
        });

        mostrarVocales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int contador = 0;
                String pelicula = peli.getText();
                String vocalSeleccionada = "";
                int vocalSel = vocal.getSelectedIndex();
                switch (vocalSel) {
                    case 0:
                        vocalSeleccionada = "A";
                        break;

                        case 1:
                        vocalSeleccionada = "E";
                        break;

                        case 2:
                        vocalSeleccionada = "I";
                        break;

                        case 3:
                        vocalSeleccionada = "O";
                        break;

                        case 4:
                        vocalSeleccionada = "U";
                        break;
                
                    default:
                        break;
                }
                for (int i = 0; i <pelicula.length(); i++) {
                    char seleccion = pelicula.charAt(i);
                    String segundaSeleccion = String.valueOf(seleccion);
                    if (segundaSeleccion.equalsIgnoreCase(vocalSeleccionada)) {
                        contador++;
                    }
                }
                resultadoVocales.setText("Numero de vocales: " + contador);
            }
            
        });


    }

}
