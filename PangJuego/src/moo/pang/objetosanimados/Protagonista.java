package moo.pang.objetosanimados;

import java.awt.Color;
import moo.multimedia.Ventana;
import moo.pang.multimedia.Juego;

public class Protagonista implements ObjetoAnimado {
    private float posicionX, posicionY;
    private Juego elJuego;
    private boolean mirandoDerecha; // Dirección del personaje

    public Protagonista(Juego elJuego) {
        this.elJuego = elJuego;
        posicionX = elJuego.getCoordenadaXMargenDerecho() / 2;
        posicionY = elJuego.getCoordenadaYSuelo() - Protagonista.ALTURA_COLISION;
        mirandoDerecha = true; // Inicialmente el personaje mira hacia la derecha
    }

    public void moverYDibujar(Ventana ventana) {
        // Mover a la derecha
        if (ventana.isPulsadoDerecha()) {
            posicionX += VELOCIDAD_HORIZONTAL;
            if (posicionX + ANCHURA_COLISION > elJuego.getCoordenadaXMargenDerecho()) {
                posicionX = elJuego.getCoordenadaXMargenDerecho() - ANCHURA_COLISION;
            }
            mirandoDerecha = true; // El personaje mira hacia la derecha
        }
        // Mover a la izquierda
        if (ventana.isPulsadoIzquierda()) {
            posicionX -= VELOCIDAD_HORIZONTAL;
            if (posicionX < elJuego.getCoordenadaXMargenIzquierdo()) {
                posicionX = elJuego.getCoordenadaXMargenIzquierdo();
            }
            mirandoDerecha = false; // El personaje mira hacia la izquierda
        }

        // Acción de disparar
        if (ventana.isPulsadoEspacio() && Disparo.getTotalDisparos() < Disparo.MAXIMO_DISPAROS_SIMULTANEOS) {
            elJuego.anyadirObjetoAnimado(new Disparo(elJuego, posicionX + ANCHURA_COLISION / 2));
        }

        // Comprobar colisión con bolas
        for (ObjetoAnimado obj : elJuego.getObjetosAnimados()) {
            if (obj instanceof Bola) {
                Bola bola = (Bola) obj;
                if (bola.getCentroY() + bola.getRadio() >= posicionY) {
                    if ((bola.getCentroX() + bola.getRadio() >= posicionX)
                            && (bola.getCentroX() - bola.getRadio() <= posicionX + ANCHURA_COLISION)) {
                        elJuego.jugadorTocado();
                        break;
                    }
                }
            }
        }

        // Dibujar el personaje
        float x = posicionX - MARGEN_IZQUIERDO_COLISION;
        ventana.dibujaCirculo(x + 24, posicionY + 16, 16, Color.orange);
        ventana.dibujaCirculo(x + 18, posicionY + 14, 3, Color.black);
        ventana.dibujaCirculo(x + 30, posicionY + 14, 3, Color.black);
        ventana.dibujaRectangulo(x + 16, posicionY + 22, 16, 3, Color.black);

        // Ajuste de los brazos dependiendo de la dirección en la que se mueve el personaje
        if (mirandoDerecha) {
            // Si el personaje mira hacia la derecha, los brazos estarán a la derecha
            ventana.dibujaTriangulo(x + 24, posicionY + 32, x + 48, posicionY + 44, x + 44, posicionY + 53, Color.orange);
            ventana.dibujaTriangulo(x + 24, posicionY + 32, x + 56, posicionY + 44, x + 52, posicionY + 53, Color.orange);
        }else {
            // Si el personaje mira hacia la izquierda, los brazos estarán a la izquierda
            // Reducimos la longitud de los brazos para que no se vean estirados
            ventana.dibujaTriangulo(x + 24, posicionY + 32, x - 10, posicionY + 44, x - 6, posicionY + 53, Color.orange); // Brazo izquierdo
            ventana.dibujaTriangulo(x + 24, posicionY + 32, x - 18, posicionY + 44, x - 14, posicionY + 53, Color.orange); // Brazo derecho
        }
        
        

        // Resto del cuerpo (piernas y detalles)
        ventana.dibujaRectangulo(x + 16, posicionY + 32, 16, 24, Color.gray);
        ventana.dibujaRectangulo(x + 14, posicionY + 56, 8, 16, Color.white);
        ventana.dibujaRectangulo(x + 26, posicionY + 56, 8, 16, Color.white);
        ventana.dibujaRectangulo(x + 10, posicionY + 68, 12, 4, Color.red);
        ventana.dibujaRectangulo(x + 26, posicionY + 68, 12, 4, Color.red);
    }

    private final static float VELOCIDAD_HORIZONTAL = 6;
    private static final float MARGEN_IZQUIERDO_COLISION = 12;
    private static final float ANCHURA_COLISION = 24;
    private static final float ALTURA_COLISION = 72;
}

