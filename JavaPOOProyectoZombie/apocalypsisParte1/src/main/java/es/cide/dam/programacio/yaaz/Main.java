package es.cide.dam.programacio.yaaz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int restarSaludZombie = 0;
        int restarSaludSuperviviente = 0;

        Scanner sc = new Scanner(System.in);
        supervivent s1 = new supervivent();
        ciutat c1 = new ciutat(100);

        System.out.println("============== Bienvenidos al videojuego zombie ==============");

        System.out.println("============== Como te llamas jugador: ==============");
        s1.setNom(sc.nextLine());

        System.out.println("============== Bienvenido al juego " + s1.getNom() + "==============");

        System.out.println("============== Vamos a jugar en un terreno misterioso... ==============");
        System.out.println("============== Como quieres que se llame la ciudad? ==============");
        c1.setNom(sc.nextLine());
        System.out.println("============== Y de cuantas rutas quieres que sea el juego? ==============");
        c1.setTamany(sc.nextInt());

        System.out.println("============== Perfecto bienvenido a " + c1.getNom()
                + ", un mapa en el que tendras que superar " + c1.getTamany() + " rutas ==============");
        System.out.println("============== Estas preparado... ==============\nPUES QUE EMPIEZE EL JUEGOOOOOOOOOOO");

        for (int i = 0; i < c1.getTamany(); i++) {
            zombie z1 = c1.devuelveZombie(i);

            System.out.println("Ha aparecido el zombie numero " + (i + 1) + ". Con cuidado " + s1.getNom() + ".");
            System.out.println("Preparate para atacar");

            while (s1.getSalut() > 0) {
                System.out.println("======================================================================");
                restarSaludZombie = s1.ataca() - z1.defensat();
                if (restarSaludZombie > 0) {
                    System.out.println("Al zombie se le resta " + restarSaludZombie + " de daño.");
                    z1.recibeDanyo(restarSaludZombie);
                    System.out.println("La vida del zombie ahora es de " + z1.getSalut() + ".");
                } else {
                    System.out.println("El zombie se ha defendido a la perfeccion, no recibe daño.");
                }

                if (z1.getSalut() <= 0 && i != (c1.getTamany() -1 )) {
                    System.out.println("======================================================================");
                    System.out.println("Zombie numero " + (i + 1) + " ha caido, sigamos avanzando.");
                    System.out.println("======================================================================");
                    break;
                }

                if (z1.getSalut() <= 0 && i == (c1.getTamany() - 1)) {
                    System.out.println("======================================================================");
                    System.out.println("Zombie numero " + (i + 1) + " ha caido.");
                    System.out.println(
                            "Felicidades " + s1.getNom() + " has ganado el juego, has sobrevivido todas las rutas.");
                    System.out.println("======================================================================");
                    break;
                }

                restarSaludSuperviviente = z1.ataca() - s1.defensat();
                if (restarSaludSuperviviente > 0) {
                    System.out.println("Al superviviente se le resta " + restarSaludSuperviviente + " de daño.");
                    s1.recibeDanyo(restarSaludSuperviviente);
                    System.out.println("La vida del superviviente ahora es de " + s1.getSalut() + ".");
                } else {
                    System.out.println("El superviviente se ha defendido a la perfeccion, no recibe daño.");
                }

                if (s1.getSalut() <= 0) {
                    System.out.println("======================================================================");
                    System.out.println("Has perdido. Nuestro superviviente " + s1.getNom() + " ha caido en batalla. Intentalo de nuevo.");
                    System.out.println("======================================================================");
                    i = 100;
                    break;
                }

            }

        }

        sc.close();
    }
}