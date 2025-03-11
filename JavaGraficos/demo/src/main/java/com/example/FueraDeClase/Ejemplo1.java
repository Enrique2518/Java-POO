package com.example.FueraDeClase;

import javax.swing.*;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        miMarco m1 = new miMarco();
        m1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m1.setVisible(true);
        
    }

}

class miMarco extends JFrame{

    public miMarco(){
        /* 
        setSize(500, 300);
        setLocation(500, 300);
        */
        

        /*Con el set bound puedes hacer el setSize y el SetLocation a la vez */
        setBounds(500, 300, 500, 500);

        /*Este metodo booleano es para indicar si queremos que la ventana se pueda agrandar o no. */
        setResizable(true);

        /*Este metodo  es paraindicar si queremos que la ventana se agrande a todo el ancho y alto de la pantalla */
        /*setExtendedState(Frame.MAXIMIZED_BOTH);*/

        setTitle("Mi primera ventana");
       
    }

}

