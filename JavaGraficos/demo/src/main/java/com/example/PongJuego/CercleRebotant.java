package com.example.PongJuego;

//Importamos los paquetes
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class CercleRebotant extends JPanel implements ActionListener, KeyListener {
    int width = 1000, height = 600; // tamaño del panel
    private int x = (width / 2), y = (height / 2); // Coordenades inicials del cercle
    private int dx = 2, dy = 2; // Velocitat del moviment en X i Y
    private final int RADI = 10; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació

    private String jugador1Nombre, jugador2Nombre; //Nombre de los jugadores antes de la partida


    //Creamos las variables para definir el ancho y el alto de nuestras palas
    int WIDTHPADDLE = 15, HEIGHTPADDLE = 80;

    // Constructor que inicialitza el panell i inicia el temporitzador
    public CercleRebotant(String jugador1Nombre, String jugador2Nombre) {
        this.jugador1Nombre = jugador1Nombre;
        this.jugador2Nombre = jugador2Nombre;
        setBackground(Color.WHITE); // Defineix el color de fons del panell

        /////////////////////////////////////////////////
        // Este setFocuseable sirve para asegurarse de que el panel (JPanel en este
        ///////////////////////////////////////////////// caso) pueda
        // recibir eventos de teclado.
        // Por defecto, algunos componentes no son "focusable"
        // En Swing, no todos los componentes pueden recibir el foco del teclado
        ///////////////////////////////////////////////// automáticamente.
        // Un JPanel no es "focusable" de manera predeterminada.
        setFocusable(true);

        // El addKeyListener es para que las funciones que crees sobre las teclas se
        // impartan en este JPanel
        addKeyListener(this);
        /////////////////////////////////////////////////

        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador
    }

    //Creamos nuestras dos paletas y les asignamos un punto de iniciación tanto verticalmente como horizontalmente.
    Paddle jugador1 = new Paddle(50, (height / 2) - (HEIGHTPADDLE / 2));
    Paddle jugador2 = new Paddle((width - 70), (height / 2) - (HEIGHTPADDLE / 2));

    //Creamos un contador que nos sumara la cantidad de puntos de cada uno de los jugadores
    int contadorj1 = 0, contadorj2 = 0;

    // Mètode per dibuixar el cercle dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d.setColor(Color.RED); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi
        g2d.fillRect(jugador1.x, jugador1.y, WIDTHPADDLE, HEIGHTPADDLE); //Pintamos la primera paleta en la izquierda del panel
        g2d.fillRect(jugador2.x, jugador2.y, WIDTHPADDLE, HEIGHTPADDLE); //Pintamos la segunda paleta en la derecha del panel

        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); //Pintamos una linea en el medio de la pantalla

        g.drawString(jugador1Nombre + " : " + contadorj1, 200, 20); //Dibujamos el nombre del jugador 1 y su contador de puntos
        g.drawString(jugador2Nombre + " : " + contadorj2, 750, 20); //Dibujamos el nombre del jugador 2 y su contador de puntos
    }

    // Mètode que s'executa a cada tic del temporitzador per moure el cercle
    @Override
    public void actionPerformed(ActionEvent e) {

        /////////////////////////////////////////////////
        /// Iniciamos un metodo para que las paletas se puedan mover hacia arriba y hacia abajo
        // Se pone getHeight para que devuelva la altura actual del JPanel,
        // Es decir el area donde se mueven las paletas
        jugador1.move(getHeight());
        jugador2.move(getHeight());
        /////////////////////////////////////////////////

        // Comprova si el cercle toca les vores horitzontals
        if (x <= 0) {
            dx = -dx; // Inverteix la direcció horitzontal
            reset(); //Si la bola atraviesa el limite izquierdo se reseteara la posicion de la bola
            contadorj2++; //Sumamos un punto al jugador derecho
        }
        // Comprova si el cercle toca les vores horitzontals
        if (x + 2 * RADI >= getWidth()) {
            dx = -dx; // Inverteix la direcció horitzontal
            reset(); //Si la bola atraviesa el limite izquierdo se reseteara la posicion de la bola
            contadorj1++; //Sumamos un punto al jugador izquierdo
        }
        // Comprova si el cercle toca les vores verticals
        if (y + 2 * RADI >= getHeight() || y <= 0) {
            dy = -dy; // Inverteix la direcció vertical
        }

        /////////////////////////////////////////////////////////////////////
        // ENTENDER ESTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        // Verifica colisión con la pala del jugador 1
        if (x <= jugador1.x + WIDTHPADDLE // La pelota está tocando o pasando la pala en X
                && y + RADI * 2 >= jugador1.y // La pelota está dentro del rango vertical de la pala
                && y <= jugador1.y + HEIGHTPADDLE) { // La pelota aún no ha pasado por debajo de la pala
            dx = -dx; // Invierte la dirección en X (rebote)
        }

        // Verifica colisión con la pala del jugador 2
        if (x + 2 * RADI >= jugador2.x // La pelota está tocando o pasando la pala en X
                && y + RADI * 2 >= jugador2.y // La pelota está dentro del rango vertical de la pala
                && y <= jugador2.y + HEIGHTPADDLE) { // La pelota aún no ha pasado por debajo de la pala
            dx = -dx; // Invierte la dirección en X (rebote)
        }

        /////////////////////////////////////////////////////////////////////

        // Actualitza la posició del cercle
        x += dx;
        y += dy;
        repaint(); // Redibuixa el panell per actualitzar la posició del cercle
    }

    //Creamos un metodo void que no devuelve nada que resetee la posicion de la bola
    void reset() {
        x = (width / 2); //Posicion horizontal inicial de la bola
        y = (height / 2); //Posicion vertical inicial de la bola
        setBackground(Color.WHITE); 
        timer.start(); //Iniciamos de nuevo nuestro temporizador
    }

    // Detectamos las teclas presionadas para mover las paletas
    public void keyPressed(KeyEvent e) {
        //Si presionamos las teclas W o UP las palas subiran hacia arriba o S o DOWN se deslizaran hacia abajo
        if (e.getKeyCode() == KeyEvent.VK_W)
            jugador1.up = true;
        if (e.getKeyCode() == KeyEvent.VK_S)
            jugador1.down = true;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            jugador2.up = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            jugador2.down = true;
    }

    // Detectamos cuando se sueltan las teclas para detener el movimiento
    public void keyReleased(KeyEvent e) {
        //Si dejamos de presionar las teclas W, UP, S o DOWN se dejaran de mover
        if (e.getKeyCode() == KeyEvent.VK_W)
            jugador1.up = false;
        if (e.getKeyCode() == KeyEvent.VK_S)
            jugador1.down = false;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            jugador2.up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            jugador2.down = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

class Paddle {

    int width = 1000, height = 600; // tamaño del panel
    int WIDTHPADDLE = 15, HEIGHTPADDLE = 80; //Tamaño de las palas

    int x, y; //Posiciones iniciales de las palas

    boolean up, down; //boleano para saber si las palas tienen que moverse hacia arriba o abajo

    static final int SPEED = 5; //Velocidad de movimiento de las palas

    //Contructor de las palas iniciando con las posiciones x e y
    Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /////////////////////////////////////////////////
    /// Creamos un metodo para saber si las palas se puedes deslizar hacia arriba o hacia abajo y si tocan
    ///  los bordes de la pantalla no podran moverse mas
    /// Se tiene que pasar por parametros un valor int que sera la altura de nuestro panel
    /// de nuestro JPanel y asi identifique la altura maxima y minima del panel
    void move(int panelHeiheht) {
        if (up && y > 0) {
            y -= SPEED; // Mueve hacia arriba
        }
        if (down && ((y + HEIGHTPADDLE) < height)) {
            y += SPEED; // Mueve hacia abajo
        }
    }
    /////////////////////////////////////////////////

}