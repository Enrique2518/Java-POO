package com.example;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 20/02/2025 				    */
/* Exercici: Examen 2 Avaluació			*/
/****************************************/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

public class Main {
    public static void main(String[] args) {

        //Creamos un array de hoteles para hacer la seleccion en el checkbox
        String hoteles[] = {"Hotel Mar", "Hotel Illa", "Hotel Muntanya"};
        
        //Creamos nuestro primer panel
        JFrame frame1 = new JFrame("Reservas de un Hotel.");
        //Le damos un diseño a nuestro frame de 9 filas y 2 culomnas
        frame1.setLayout(new GridLayout(9, 2));
        //Le damos un tamaño de 700X700 px
        frame1.setSize(700, 700);
        //Indicamos que si le damos a la cruz roja de la ventana se acabara el programa
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Panel 1
        //Introducimos un Jlabel donde nos indicara donde va el nombre
        JLabel nombre = new JLabel("Nombre: ");
        //creamos un JTextField para introducir ahi nuestro nombre
        JTextField nombreInt = new JTextField(10);
        //Creamos el panel 1 
        JPanel panel1 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel1.setLayout(new BorderLayout());
        //Añadimos el atributo nombre al panel 1 y lo colocamos a la izquierda
        panel1.add(nombre, BorderLayout.WEST);
        //Añadimos el atributo nombreIntr al panel 1 y lo colocamos a la derecha
        panel1.add(nombreInt, BorderLayout.CENTER);


        //Panel 2
        //Introducimos un Jlabel donde nos indicara donde va el dni
        JLabel dni = new JLabel("DNI: ");
        //creamos un JTextField para introducir ahi nuestro nombre
        JTextField intrDni = new JTextField(10);
        //Introducimos un Jlabel donde nos indicara si el dni es correcto o no
        JLabel correcto = new JLabel("KO");
        //Creamos el panel 22
        JPanel panel22 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel22.setLayout(new BorderLayout());
        //Añadimos el atributo intrDni al panel 22 y lo colocamos a la izquierda
        panel22.add(intrDni, BorderLayout.WEST);
        //Añadimos el atributo correcto al panel 1 y lo colocamos a la derecha
        panel22.add(correcto, BorderLayout.EAST);
        //Creamos el panel 2
        JPanel panel2 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel2.setLayout(new BorderLayout());
        //Añadimos el atributo dni al panel 2 y lo colocamos a la izquierda
        panel2.add(dni, BorderLayout.WEST);
        //Añadimos el panel 22 al panel 2 y lo colocamos a la derecha
        panel2.add(panel22, BorderLayout.EAST);


        //Panel3
        //Introducimos un Jlabel donde nos indicara donde va la datacheckIn
        JLabel dataCheckIn = new JLabel("Data Check-in:(dd/MM/yyyy) ");
        //creamos un JTextField para introducir ahi nuestro datacheckIntrod
        JTextField dataCheckIntrod = new JTextField(10);
         //Creamos el panel 3
        JPanel panel3 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel3.setLayout(new BorderLayout());
        //Añadimos el atributo dataCheckIn al panel 3 y lo colocamos a la izquierda
        panel3.add(dataCheckIn, BorderLayout.WEST);
        //Añadimos el atributo datachrckIntrod al panel 3 y lo colocamos a la derecha
        panel3.add(dataCheckIntrod, BorderLayout.CENTER);


        //Panel4
        //Introducimos un Jlabel donde nos indicara donde va la hotel
        JLabel hotel = new JLabel("Hotel: ");
        //creamos un JComboBox para seleccionar ahi nuestro hotel
        JComboBox<String> hotelSeleccionado = new JComboBox<>(hoteles);
        //Creamos el panel 4
        JPanel panel4 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel4.setLayout(new BorderLayout());
        //Añadimos el atributo hotel al panel 4 y lo colocamos a la izquierda
        panel4.add(hotel, BorderLayout.WEST);
        //Añadimos el atributo hotelSeleccionado al panel 4 y lo colocamos a la derecha
        panel4.add(hotelSeleccionado, BorderLayout.EAST);


        //Panel 5
        //Introducimos un JSlider donde nos indicara cuantas noches estaremos en el hotel
        //Le damos un espaciado de 1 en 1 con un valor maximo de 7 y un comenzado en el numero 4
        JSlider noches = new JSlider(0,1, 7, 4);
        noches.setMajorTickSpacing(1);
        //Pintamos las rayitas que nos indicara donde nos posicionamos
        noches.setPaintTicks(true);
        //Y pintamos los numeros de los dias
        noches.setPaintLabels(true);
        //Creamos el panel 4
        JPanel panel5 = new JPanel();
        //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel5.setLayout(new BorderLayout());
        //Añadimos el atributo noches al panel 5 y lo colocamos en el centro
        panel5.add(noches, BorderLayout.CENTER);


        //Panel 6
        //Introducimos un JButton donde cuando lo apretemos nos saldran todos los datos de la reserva
        JButton mostrarReserva = new JButton("Guardar reserva");
        //Introducimos un Jlabel donde nos indicaratodos los datos de la reserva
        JLabel resultadoReserva = new JLabel("");
         //Creamos el panel 6
        JPanel panel6 = new JPanel();
          //Le damos un diseño a nuestro panel para que podamos diferenciarlo en varias posiciones
        panel6.setLayout(new BorderLayout());
        //Añadimos el atributo mostrarReserva al panel 6 y lo colocamos en el norte
        panel6.add(mostrarReserva, BorderLayout.NORTH);
        //Añadimos el atributo resultadoReserva al panel 6 y lo colocamos en el sur
        panel6.add(resultadoReserva, BorderLayout.SOUTH);


        //Añadimos todos los paneles al frame creado
        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(panel3);
        frame1.add(panel4);
        frame1.add(panel5);
        frame1.add(panel6);


        //Hacemos visitble esta ventana
        frame1.setVisible(true);


        //Creamos un evento donde nos va a indicar cada vez que presionemos una tecla si el dni es correcto o no
        intrDni.addKeyListener(new KeyListener() {
            //Estos tres metodos indican que mientras estas pulsando, dejas de pulsar y has pulsado si el dni es incorrecto te mostrara por pantalla en el 
            //JLabel un ="KO" si el dni es correcto te mostrara "OK"
            @Override
            public void keyTyped(KeyEvent e) {
                if (validarDNI(intrDni.getText())) {
                    correcto.setText("OK");
                }else{
                    correcto.setText("KO");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (validarDNI(intrDni.getText())) {
                    correcto.setText("OK");
                }else{
                    correcto.setText("KO");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (validarDNI(intrDni.getText())) {
                    correcto.setText("OK");
                }else{
                    correcto.setText("KO");
                }
            }
            
        });


        //Creamos un evento donde nos va a indicar cada vez que estemos fuera del foco de le fecha y este vacia esta nos muestre un mensaje en la pantalla de que la fecha esta vacia
        dataCheckIntrod.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                //Condicional: si el texto del Jtextfiel de data es vacio nos saltara este mensaje
                if (dataCheckIntrod.getText().equalsIgnoreCase("")) {
                    //Si la fecha esta vacia nos moestrara este mensaje
                    JOptionPane.showMessageDialog(frame1, "Has dejado la fecha en blanco.");
                }

                //Condicional si la fecha no es valida al metodo creado mas abajo de esDataValida nos saldra que no es correcto
                if (esDataValida(dataCheckIntrod.getText()) == false) {
                    JOptionPane.showMessageDialog(frame1, "No es correcta este fecha");
                }
            }
            
        });


        //Creamos un evento que depende del hotel seleccionado en el JComboBox el slider sera de mayor o menor medida
        hotelSeleccionado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos una variable que recoga el texto del elemento seleccionado en el JComboBox
                String hotSec = (String)hotelSeleccionado.getSelectedItem();
                //Creamos la condicinal que si el hotel es igual a la variable creada anteriormente el JSlider si valor maximo varie
                if ("Hotel Mar".equals(hotSec)) {
                    noches.setMaximum(7);
                }else if ("Hotel Illa".equals(hotSec)) {
                    noches.setMaximum(15);
                }else if ("Hotel Muntanya".equals(hotSec)) {
                    noches.setMaximum(30);
                }
            }
            
        });


        //Creamos un evento que depende de las noches seleccionadas en el JSlider nos muestre un mensaje
        noches.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //Si el valor del JSlider llega a su maximo nos enseñara este mensaje por pantalla
                if (noches.getValue() == noches.getMaximum()) {
                    JOptionPane.showMessageDialog(frame1, "Estancia maxima en este hotel");
                }
            }
            
        });

        ////Creamos un evento que nos muestre toda la info de la reserva
        mostrarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos una variable vacia para despues recoger un valor
                String valorHotelSeleccionado = "";
                //Creamos una variable int para saber que elemento estamos seleccioando en el JComboBox
                int valHot = hotelSeleccionado.getSelectedIndex();
                //Creamos un switch que depende de que en que casilla este nuestro hotel seleccionado valorHotelSeleccionado sera una cadena de texto diferente
                switch (valHot) {
                    case 0:
                        valorHotelSeleccionado = "Hotel Mar";
                        break;

                        case 1:
                        valorHotelSeleccionado = "Hotel Illa";
                        break;

                        case 2:
                        valorHotelSeleccionado = "Hotel Muntanya";
                        break;
                
                    default:
                        break;
                }
                //Mostramos en el JLabel resultadoReserva toda la informacion seleccionada de nuestra reserva
                resultadoReserva.setText("Reserva: " + nombreInt.getText() + ", " + intrDni.getText() + ", " + dataCheckIntrod.getText() + ", " + valorHotelSeleccionado + ", " + noches.getValue() + " noches.");
            }
            
        });


    }

    public static boolean validarDNI(String dni) {
    // Verifica que el format sigui correcte (8 dígits + 1 lletra)
    return dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
            // Calcula la lletra esperada i la compara amb la lletra proporcionada
            "TRWAGMYFPDXBNJZSQVHLCKE"
                    .charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character.toUpperCase(dni.charAt(8));
    }

    public static boolean esDataValida(String dataString) {
        try {
            // Defineix el format esperat de la data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
            // Converteix la cadena de text en un objecte LocalDate
            LocalDate dataEntrada = LocalDate.parse(dataString, formatter);
    
            // Comprova si la data no és anterior a la data actual
            return !dataEntrada.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            // Captura l'excepció si la cadena no té el format correcte i retorna false
            return false;
        }
    }


}