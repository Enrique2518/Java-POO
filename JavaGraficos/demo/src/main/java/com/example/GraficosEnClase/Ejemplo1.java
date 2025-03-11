package com.example.GraficosEnClase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Dibuix amb Java Swing");

        JPanel panel = new JPanel(){
            private Image imatge = new ImageIcon("demo\\src\\main\\java\\com\\example\\Imagen1.png").getImage();

            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                //Dibujar una linea
                g2d.drawLine(50, 50, 200, 50);

                //Dibujar un rectangulo
                g2d.drawRect(50, 70, 100, 50);

                //Dibujar un rectagunlo relleno
                //Cambiamos el color en la que vamos a pintar los elementos, como si en el paint hubiesemos cambiado el color a azul
                g2d.setColor(Color.blue);
                g2d.fillRect(200, 70, 100, 50);

                //Dibujamos un circulo que tambien sera de color azul
                g2d.drawOval(50, 150, 50, 50);

                //Cambiamos al color rojo
                g2d.setColor(Color.RED);
                //Dibujamos un circulo relleno que sera de color rojo
                g2d.fillOval(150, 150, 50, 50);

                //Cambiamos el color
                g2d.setColor(Color.green);
                //Dibujamos un arco
                g2d.drawArc(250, 150, 50, 50, 0, 100);

                //Dibujar el poligono
                int[] xPoint = {100, 125, 150};
                int[] yPoint = {250, 200, 250};
                g2d.setColor(Color.ORANGE);
                g2d.drawPolygon(xPoint, yPoint, 3);

                //Dibujar texto
                g2d.setColor(Color.black);
                g2d.drawString("Hola Lluis", 50, 300);

                g2d.drawImage(imatge, 200, 250, this);
            }
        };

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
