package com.example.PruebaExamenSwingMi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Bloque {

    int x, y;
    int width, height;
    // 1.Creamos la variable boolean para saber si esta destruido o no
    boolean destruido;

    public Bloque(int x, int y) {
        this.x = x;
        this.y = y;
        width = 100;
        height = 30;
        // 2.La añadimos en el cosntructor como false porque no esta destruido al
        // principio de la partida
        destruido = false;
    }

    // 3.Creamos un metodo reiniciar para cuando el bloque reeaparezca de nuevo
    public void reiniciar() {
        destruido = false;
    }

}

class Paleta {

    int x, y;
    int width, height;

    int speed = 4;

    boolean left, right;

    public Paleta() {
        x = 450;
        y = 500;
        width = 100;
        height = 30;
    }

    public void moverse(int widthPantalla) {
        if (left && x >= 0) {
            x -= speed;
        }
        if (right && (x + width) <= widthPantalla) {
            x += speed;
        }
    }

}

class Pelota {

    int x, y;
    int radio;
    int dx, dy;

    public Pelota() {
        x = 500;
        y = 200;
        radio = 20;
        dx = 2;
        dy = 2;
    }

    public void mover(int width, int height) {
        x += dx;
        y += dy;
        if (x <= 0 || (x + radio) >= width) {
            dx = -dx;
        }
        if (y <= 0 || (y + radio) >= height) {
            dy = -dy;
        }
    }

}

class Panel extends JPanel implements ActionListener, KeyListener {

    int width = 1000, height = 600;

    Pelota p1 = new Pelota();

    Paleta paleta = new Paleta();

    ArrayList<Bloque> bloques = new ArrayList<>();

    Bloque b1 = new Bloque(150, 100);
    Bloque b2 = new Bloque(300, 100);
    Bloque b3 = new Bloque(450, 100);
    Bloque b4 = new Bloque(600, 100);
    Bloque b5 = new Bloque(750, 100);
    int contador = 0;

    Timer timer;
    // 4.Creamos un timer nuevo para la reaparicion de los bloques
    Timer timerReaparecer;

    public Panel() {
        setBackground(Color.GRAY);
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        // 5.Añadimos los bloques al arraylist de bloques
        bloques.add(b1);
        bloques.add(b2);
        bloques.add(b3);
        bloques.add(b4);
        bloques.add(b5);
        // 9.Timer para hacer reaparecer los bloques de nuevo
        timerReaparecer = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarBloques();
            }
        });
        timerReaparecer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillOval(p1.x, p1.y, p1.radio, p1.radio);
        g2d.fillRect(paleta.x, paleta.y, paleta.width, paleta.height);
        g2d.drawString("Puntos: " + contador, 50, 580);
        g2d.setColor(Color.RED);
        // g2d.fillRect(b1.x, b1.y, b1.width, b1.height);
        // g2d.fillRect(b2.x, b2.y, b2.width, b2.height);
        // g2d.fillRect(b3.x, b3.y, b3.width, b3.height);
        // g2d.fillRect(b4.x, b4.y, b4.width, b4.height);
        // g2d.fillRect(b5.x, b5.y, b5.width, b5.height);
        // 6.Dibujamos los bloques del arrayList
        for (Bloque bloque : bloques) {
            if (!bloque.destruido) {
                g2d.fillRect(bloque.x, bloque.y, bloque.width, bloque.height);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paleta.moverse(width);
        p1.mover(width, height);

        // 4.Finalizamos el juego si la pelota toca la parte inferior de la pantalla
        if (p1.y + p1.radio >= height) {
            gameOver("Has perdido");
            return;
        }

        //5.Verifica si todos los bloques están destruidos (fin del juego)
        boolean todosDestruidos = true;
        for (Bloque bloque : bloques) {
            if (!bloque.destruido) {
                todosDestruidos = false;
                break;
            }
        }

        //6.Verifica si todos los bloques han sido destruidos antes del timer y finaliza el juego
        if (todosDestruidos) {
            gameOver("¡Felicidades! Todos los bloques han sido destruidos.");
            return; // Detener la ejecución
        }

        // 7. Creamos en el repaint de la pantalla que si la pelota toca el bloque este
        // bloque desaparezca y sume un punto al contador
        for (Bloque bloque : bloques) {
            if (!bloque.destruido && p1.x + p1.radio > bloque.x && p1.x < bloque.x + bloque.width &&
                    p1.y + p1.radio > bloque.y && p1.y < bloque.y + bloque.height) {
                p1.dy = -(p1.dy);
                bloque.destruido = true;
                contador++;
            }
        }

        if (p1.x <= paleta.x + paleta.width && p1.y + p1.radio >= paleta.y && p1.y <= paleta.y + paleta.height) {
            p1.dy = -(p1.dy);
        }
        repaint();
    }

    // 1.Creamos un metodo gameOver para cuando se acabe el juego
    public void gameOver(String mensaje) {
        // 2.Detener el Timer
        timer.stop();
        timerReaparecer.stop();

        // 3.Mostrar el mensaje de fin de juego
        JOptionPane.showMessageDialog(this, mensaje, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
    }

    // 8.Creamos un metodo que no nos devuelve nada, unicamente vuelve a pintar los
    // bloques
    public void reiniciarBloques() {
        for (Bloque bloque : bloques) {
            bloque.reiniciar();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            paleta.left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            paleta.right = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            paleta.left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            paleta.right = false;
    }

}

public class PruebaExamen {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Juego destruir bloques");

        Panel panel = new Panel();

        frame.add(panel);
        frame.setSize(1016, 638);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
