package com.example.PruebaExamenSwingMio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

//7.Creamos la clase Pelota
class Pilota {

    // 8.Creamos sus variables que seran x e y que seran los puntos iniciales de la
    // pelota y radio que le dara el radio a nuestro circulo
    protected int x, y;
    protected int radio;

    // 41.Creamos una variable imagen que sera para determinar si queremos una
    // pelota de basket, futbol o tenis
    Image imagen;

    // 15.Ahora vamos a darle un movimiento a nuestras pelotas
    protected int dx, dy; // Nos indicaran la direccion de la pelota

    // 9.Creamos su constructor para poder pintarlo
    // 42.Le damos un parametro en el constructor de la pelota que sera la imagen
    // 52.En el cosntructor le damos los parametros radio, x e y para que mas tarde pongamos unos radios dependiendo de la imagen que escogamos y tengan posiciones iniciales aleatorias

    public Pilota(String imagenRuta, int radio, int x, int y) {
        // 10.Las pelotas empezaran su posicion en la x = 50, y = 100 y tendran un radio
        // de 20
        // x = 50;
        // y = 100;
        // radio = 20;
        //53. Mas tarde les daremos un valor a estos atributos cuando creemos las pelotas
        this.x = x;
        this.y = y;
        this.radio = radio;

        // 16.Le da una velocidad de 2 de movimiento
        dx = 2;
        dy = 2;

        // 43.Iniciamos la imagen en el cosntructor
        this.imagen = new ImageIcon(getClass().getResource(imagenRuta)).getImage();
    }

    // 17.Creamos un metodo moverse para que la pelotas se muevan.
    public void moverse(int width, int height) {
        // 18.Mueve la pelota en la dirección indicada por dx y dy
        x += dx;
        y += dy;

        // 19.Si la pelota toca los bordes, cambia la dirección
        if (x <= 0 || (x + radio) >= width) {
            dx = -dx;
        }
        if (y <= 0 || (y + radio) >= height) {
            dy = -dy;
        }
    }

}

// 3.Creamos la clase Panel que extendera de JPanel para que sea un panel
// 20.Hacemos que nuestro Panel implemente el ActionListener para darle acciones
class Panell extends JPanel implements ActionListener {

    // 11.Creamos una pelota en nuestro Panel
    // Pilota p1 = new Pilota();

    // 12.Le damos los valores que medrian nuestro panel
    private int width = 1000, height = 600;
    // 21.Creamos un Timer que hara que nuestras pelotas se muevan cada cierto
    // tiempo indicado
    private final Timer timer;
    // 30.Creamos un arrayList de Pelotas
    private final ArrayList<Pilota> listaP = new ArrayList<>();

    // 44.Creamos un JComboBox
    private final JComboBox<String> combobox;

    // 4. Creamos un constructor de JPanel para que lo pinte y le damos un
    // backgraound
    // 45.Le damos un parametro en el constructor que sera un JComboBox
    public Panell(JComboBox<String> combobox) {
        this.combobox = combobox;
        setBackground(Color.CYAN);
        // 22.En el contructor del panel iniciamos nuestro timer, con un delay de 10 ms
        timer = new Timer(10, this);
        // 23.Iniciamos el timer
        timer.start();
    }

    // 31.Creamos el metdo para añadir pelotas a nuestro panel
    public void afegirPilota() {
        // 32.Limitamos el numero de pelotas que podemos crear que seran 10
        if (listaP.size() >= 10) {
            return;
        }

        //46.Creamos dos String uno para guardar el valor del String seleccionado en el JComboBox
        String llista = (String) combobox.getSelectedItem();
        //47.Creamos un String que nos guardara el valor de la imagen para cada pelota
        String imagen = "/tennis.png";
        //54.Creamos el atributo radioPelota, x e y posiciones de la pelota
        int radioPelota = 0;
        int x = 0;
        int y = 0;

        //48.Creamos un switch para que depende de la eleccion sera una imagen u otra
        switch (llista) {
            case "Basket":
                imagen = "/basketball.png";
                radioPelota = 60;
                break;

            case "Futbol":
                imagen = "/football.png";
                radioPelota = 40;
                break;

            case "Tenis":
                imagen = "/tennis.png";
                radioPelota = 20;
                break;
        }

        //55.Creamos un random que nos escogera dos valores entre x 0 y la anchura del panel, e y de 0 a la altura del panel
        Random ran  = new Random();
        x = ran.nextInt(width);
        y = ran.nextInt(height);

        //56.Creamos una condicion por si se nos bugea las pelotas que les de una posicion predeterminada
        if (x <= 0 || (x + radioPelota) >= width) {
            x = 50;
        }

        if (y <= 0 || (y + radioPelota) >= height) {
            y = 50;
        }

        // 33.Añadiremos una pelota nueva
        //49.Añadimos la imagen en las pelotas creadas
        //57.Añadimos el radio de la pelota, la x y la y;
        listaP.add(new Pilota(imagen, radioPelota, x, y));
    }

    public void aumentarVelocidad(){
        for (Pilota pilota : listaP) {
            if (pilota.dx == 20) {
                JOptionPane.showMessageDialog(null, "No se puede aumentar mas la velocidad", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Aumentar velocidad aqui
                pilota.dx += 2;
                pilota.dy += 2;

            }
            
        }
    }

    // 13.Pintamos la pelota con paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        // A14.qui pintaremos la pelota
        // g2d.fillOval(p1.x, p1.y, p1.radio, p1.radio);

        // 34.Creamos un for que nos pintara todas las pelotas de nuestra arrayList
        for (Pilota pilota : listaP) {
            //g2d.fillOval(pilota.x, pilota.y, pilota.radio, pilota.radio);
            //50.Creamos las imagenes que seran las pelotas pero no son circulos
            g.drawImage(pilota.imagen, pilota.x, pilota.y, pilota.radio, pilota.radio, this);
        }
    }

    // 24.Implementamos el metodo actionPerformed de la Interfaz ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // 25.Implementamos el metodo moverse a la pelota
        // p1.moverse(width, height);
        // 26.La repintamos para que se vea su movimiento

        // 35.Creamos un bucle que nos repinte el movimiento de todods nuestras pelotas
        for (int i = 0; i < listaP.size(); i++) {
            Pilota p = listaP.get(i);
            p.moverse(width, height);
        }
        repaint();
    }

}

public class CercleRebotant {

    // 1. Creamos el main
    public static void main(String[] args) {
        // 37.Creamos un array de Strings para el JComboBox
        String tipoPelotas[] = { "Basket", "Futbol", "Tenis" };
        // 38.Creamos el JComboBox para poder indicar que clase de pelota queremos
        JComboBox<String> seleccionPelotas = new JComboBox<>(tipoPelotas);

        // 2.Creamos el JFrame donde estara nuestro panel con las bolas
        JFrame frame = new JFrame("Pilotes");

        // 5. Creamos un objeto panel que sera donde pintemos nuestras pelotas
        //51.En el panel metemos nuestro ComboBox creado anteriormente para seleccionar que tipo de pelota queremos
        Panell p1 = new Panell(seleccionPelotas);

        // 6. Añadimos el panel en el Jframe y le damos todas estos sets
        frame.add(p1);
        frame.setResizable(false);
        frame.setSize(1016, 638);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // 27.Creamos otro JFrame donde habra un boton de añadir
        JFrame frame2 = new JFrame("Añadir pelota");
        // 39.Le damos un Layout a nuestro segundo frame
        frame2.setLayout(new BorderLayout());
        //Ejemplo
        //frame2.setLayout(new GridLayout(3, 1));

        // 28.Creamos un boton para añadir pelotas
        JButton b1 = new JButton("Añadir pelota");
        b1.setSize(100, 100);

        JButton b2 = new JButton("Aumentar velocidad");
        b2.setSize(100, 100);

        // 36.Añadimos el escuchador al boton 1
        b1.addActionListener(e -> p1.afegirPilota());

        b2.addActionListener(e -> p1.aumentarVelocidad());

        // 29.Añadimos en el 2 Frame el boton de añadir pelotas
        frame2.add(b1, BorderLayout.NORTH);
        // 40.Añadimos en el 2 Frame el JComboBox de añadir pelotas
        frame2.add(seleccionPelotas, BorderLayout.SOUTH);
        frame2.add(b2, BorderLayout.CENTER);
        frame2.setResizable(false);
        frame2.setSize(300, 300);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);

        // Comprobacion anchura del panel y del frame
        // System.out.println(frame.getWidth());
        // System.out.println(p1.getWidth());

        // Comprobacion altura del panel y del frame
        // System.out.println(frame.getHeight());
        // System.out.println(p1.getHeight());

    }

}
