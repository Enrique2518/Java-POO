/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU6EX01 			        */
/****************************************/

package com.example;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Calculadora {

    public static void main(String[] args) {

        //Hacemos el try catch de un Look and Feel
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Creamos un JFrame que sera nuestra ventana.
        JFrame ventana = new JFrame("Calculadora");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creamos dos Jtextfield para introducir texto(Seran numeros)
        JTextField numero1 = new JTextField(4);
        JTextField numero2 = new JTextField(4);
        //Y craemos un JLabel resultado que nos dara el reultado de los dos numero anterioires.
        JLabel resultado = new JLabel();

        //Creamos un panel para introducir en el panel los dos numeros y el reultado
        JPanel panel1 = new JPanel();
        panel1.add(numero1);
        panel1.add(numero2);
        panel1.add(resultado);

        //Creamos los botones que tendran la funcion de sumar, restar, multiplicar y dividir.
        JButton suma = new JButton("+");
        JButton resta = new JButton("-");
        JButton multiplicacion = new JButton("*");
        JButton division = new JButton("/");

        //Añadimos los botones anteriores a un panel nuevo.
        JPanel panel2 = new JPanel();
        panel2.add(suma);
        panel2.add(resta);
        panel2.add(multiplicacion);
        panel2.add(division);

        //Creamos las funciones de que queremos que hagan nuestros botones.

        //Empezamos con la suma.
        //Cuando presionemos el boton de la suma ejecutara una accion
        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Probara si los dos numeros son numeros y no son otra cosa(letras o signos...)
                try {
                    int numeroUno = Integer.parseInt(numero1.getText());
                    int numeroDos = Integer.parseInt(numero2.getText());
                    //Si es asi cogera los dos numeros y los sumara 
                    int resultadoFinal = suma(numeroUno, numeroDos);
                    //Y imprimiremos en el Jlabel nuestro resultado de la suma de los dos numeros
                    String imprimirResultado = String.valueOf(resultadoFinal);
                    resultado.setText(imprimirResultado);
                    //Si hay algun error mostrara por pantalla este mensaje en el JLabel: Número ingresado no válido
                } catch (NumberFormatException ea) {
                    resultado.setText("Número ingresado no válido.");
                    ventana.pack();
                }
            }
            
        });

        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Probara si los dos numeros son numeros y no son otra cosa(letras o signos...)
                try {
                    int numeroUno = Integer.parseInt(numero1.getText());
                    int numeroDos = Integer.parseInt(numero2.getText());
                    //Si es asi cogera los dos numeros y los restara
                    int resultadoFinal = resta(numeroUno, numeroDos);
                    //Y imprimiremos en el Jlabel nuestro resultado de la resta de los dos numeros
                    String imprimirResultado = String.valueOf(resultadoFinal);
                    resultado.setText(imprimirResultado);
                    //Si hay algun error mostrara por pantalla este mensaje en el JLabel: Número ingresado no válido
                } catch (NumberFormatException ea) {
                    resultado.setText("Número ingresado no válido.");
                    ventana.pack();
                }
            }
            
        });

        multiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Probara si los dos numeros son numeros y no son otra cosa(letras o signos...)
                try {
                    int numeroUno = Integer.parseInt(numero1.getText());
                    int numeroDos = Integer.parseInt(numero2.getText());
                    //Si es asi cogera los dos numeros y los multiplicara
                    int resultadoFinal = multiplicacion(numeroUno, numeroDos);
                    //Y imprimiremos en el Jlabel nuestro resultado de la multiplicacion de los dos numeros
                    String imprimirResultado = String.valueOf(resultadoFinal);
                    resultado.setText(imprimirResultado);
                    //Si hay algun error mostrara por pantalla este mensaje en el JLabel: Número ingresado no válido
                } catch (NumberFormatException ea) {
                    resultado.setText("Número ingresado no válido.");
                    ventana.pack();
                }
            }
            
        });

        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Probara si los dos numeros son numeros y no son otra cosa(letras o signos...)
                try {
                    int numeroUno = Integer.parseInt(numero1.getText());
                    int numeroDos = Integer.parseInt(numero2.getText());
                    //Si es asi cogera los dos dividira y los multiplicara
                    //Si el divisor es igual que 0 nos mostrara un mensaje por pantalla : No se puede dividir entre 0.
                    if (numeroDos == 0) {
                        resultado.setText("No se puede dividir entre 0.");
                        ventana.pack();
                    }
                    int resultadoFinal = division(numeroUno, numeroDos);
                    String imprimirResultado = String.valueOf(resultadoFinal);
                    //Sino en el Jlabel mostrara nuestro resultado de la multiplicacion de los dos numeros
                    resultado.setText(imprimirResultado);
                    //Si hay algun error mostrara por pantalla este mensaje en el JLabel: Número ingresado no válido
                } catch (NumberFormatException ea) {
                    resultado.setText("Número ingresado no válido.");
                    ventana.pack();
                    //Este error es por si el divisor es igual que 0
                }catch(ArithmeticException es){
                    
                }
            }
            
        });

        //Añadimos en nuestro Jframe los paneles
        ventana.add(panel1, BorderLayout.NORTH);
        ventana.add(panel2,  BorderLayout.SOUTH);
        //Los empaquetamos en un tamaño automatico de una ventana
        ventana.pack();
        //Hacemos visible nuestra ventana.
        ventana.setVisible(true);
    }

    //Creamos metodos que nos devolvera un entero: 
    //Suma
    static int suma(int numero1, int numero2){
        //Sumamos los dos numeros y creamos una variable con este resultado
        int resultado = numero1 + numero2;
        //Devolvemos el resultado de la suma
        return resultado;
    }
    //Resta
    static int resta(int numero1, int numero2){
        //Restamos los dos numeros y creamos una variable con este resultado
        int resultado = numero1 - numero2;
        //Devolvemos el resultado de la resta
        return resultado;
    }
    //Multiplicacion
    static int multiplicacion(int numero1, int numero2){
        //Multiplicamos los dos numeros y creamos una variable con este resultado
        int resultado = numero1 * numero2;
        //Devolvemos el resultado de la multiplicación
        return resultado;
    }
    //Division.
    static int division(int numero1, int numero2){
        //Dividimos los dos numeros y creamos una variable con este resultado
        int resultado = numero1 / numero2;
        //Devolvemos el resultado de la división
        return resultado;
    }
}
