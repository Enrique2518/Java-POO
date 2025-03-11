package es.cide.dam.programacio.yaaz;

/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* Creamos nuestras variables */
        Scanner sc = new Scanner(System.in);
        supervivent s1 = new supervivent();
        novaCiutat c2 = new novaCiutat(100);

        /* Nos aparecera en la terminal para empezar a jugar */
        System.out.println("============== Bienvenidos al videojuego zombie ==============");

        System.out.println("============== Como te llamas jugador: ==============");
        s1.setNom(sc.nextLine());

        System.out.println("============== Bienvenido al juego " + s1.getNom() + "==============");

        System.out.println("============== Vamos a jugar en un terreno misterioso... ==============");
        System.out.println("============== Como quieres que se llame la ciudad? ==============");
        c2.setNom(sc.nextLine());
        System.out.println("============== Y de cuantas rutas quieres que sea el juego? ==============");
        c2.setTamany(sc.nextInt());

        System.out.println("============== Perfecto bienvenido a " + c2.getNom()
                + ", un mapa en el que tendras que superar " + c2.getTamany() + " rutas ==============");
        System.out.println("============== Estas preparado... ==============\nPUES QUE EMPIEZE EL JUEGOOOOOOOOOOO");

        /* Creamos un bucle para que recorra el array de zombies en nuestra nueva ciudad */
        for (int i = 0; i < c2.getTamany(); i++) {
            /* Creamos un nuevo zombie donde pondremos dentro de este objeto los zombie que creamos en cada ruta con el array de zombies */
            zombie z1 = c2.devuelveZombie(i);
            /* Creamos un artefacto, no hace nada ahora pero mas adelante tendra una funcionalidad */
            artefactes a1;

            /*Creamos una condicion de que si el zombie es de clase zombie nos imprima un mensaje y si es de clase superzombie imprime otro mensaje */
            if (z1 instanceof superZombie) {
                System.out.println("Ha aparecido un SUPERZOMBIE, cuidado jugador.");
                System.out.println("Preparate para atacar");
            } else {
                System.out.println("Ha aparecido el zombie numero " + (i + 1) + ". Con cuidado " + s1.getNom() + ".");
                System.out.println("Preparate para atacar");
            }

            /* Creamos otro bucle para la batalla */
            do {

                /*Lucha entre el superviviente y el zombie */
                lucha(s1, z1);
                
                /* Mientras que la salud del zombie sea mayor que cero o el superviviente se repetira el bucle */
            } while (z1.getSalut() > 0 && s1.getSalut() > 0);

            /* Si es el zombie el que ha muerto porque su salud es menor o igaul que 0 */
            if (z1.getSalut() <= 0) {

                /*Imprimimos por pantalla que ha caido en combate */
                System.out.println("======================================================================");
                    System.out.println("Zombie numero " + (i + 1) + " ha caido, sigamos avanzando.");
                    /* Lo que ahora aparece una caja */
                    System.out.println("Ha aparecido una caja... habra algo?");

                    /*El artefacto que hemos creado antes ahora tendra un valor que hemos creado con la nueva ciutat con su array de artefactes */
                    a1 = c2.obrirEnCasDeEmergencia(i);

                    /*Si la caja tiene un peso determinado tendra unos valores definidos en las clases */
                    switch (a1.getPes()) {

                        /*Si el peso del artefacto es 1 sera un arma de fuego y su ataque se multiplicara */
                        case 1:
                            System.out.println("Multiplicamos el ataque al superviviente con este valor: "
                                    + a1.getValorArtefacte());
                            s1.aumentoAtaqueMultiplicado(a1);
                            System.out.println("El ataque de nuestro superviviente ahora es de " + s1.getAtaque());
                            break;

                            /*Si el peso del artefacto es 2 sera un arma de acero y su ataque se sumara */
                        case 2:
                            System.out.println(
                                    "Sumamos el ataque al superviviente con este valor: " + a1.getValorArtefacte());
                            s1.aumentoAtaqueSumar(a1);
                            System.out.println("El ataque de nuestro superviviente ahora es de " + s1.getAtaque());
                            break;

                            /*Si el peso del artefacto es 3 sera una farmaciola y su salud se aumentara */
                        case 3:
                            System.out
                                    .println("Sumamos vida al superviviente con este valor: " + a1.getValorArtefacte());
                            s1.auemntoSalud(a1);
                            System.out.println("La vida de nuestro superviviente ahora es de " + s1.getSalut());
                            break;

                            /*Si el peso del artefacto es 4 sera un escudo y su defensa se multiplicara */
                        case 4:
                            System.out.println("Sumamos la defensa de nuestro superviviente con este valor: "
                                    + a1.getValorArtefacte());
                            s1.aumentoDefensa(a1);
                            System.out.println("La defensa de nuestro superviviente ahora es de " + s1.getDefensa());
                            break;

                            /*No habra nada dentro del artefacto */
                        case 5:
                            System.out.println("No hay nada.");
                            break;
                    }
               /*Si es el superviviente el que ha caido se acabara el juego e imprimiremos un mensaje por pantalla. */ 
            }else{
                System.out.println("======================================================================");
                System.out.println("Has perdido. Nuestro superviviente " + s1.getNom()
                        + " ha caido en batalla. Intentalo de nuevo.");
                System.out.println("======================================================================");
                i = 100;
            }
        }

        /*Si el superviviente tiene una salud mayor que 0 sera porque ha ganado el juego y lo imprimiremos por pantalla */
        if (s1.getSalut() > 0) {
            System.out.println("Felicidades " + s1.getNom() + " has llegado vivo.");
        }

        sc.close();
    }

    /*Creamos un metodo estatico para implementarlo en el main en el que se pelearan el zombie y el superviviente */

    public static void lucha(supervivent s1, zombie z1){

        /*Creamos dos cariables que utilizaremos mas adelante para la lucha entre sup y zombie */
        int restarSaludZombie = 0;
        int restarSaludSuperviviente = 0;

        /*Ataque del superviviente */

        System.out.println("======================================================================");
        /*En la variable que antes hemos creado metemos el valor del ataque del superviviente y la defensa del zombie */
        restarSaludZombie = s1.ataca() - z1.defensat();
        /*Creamos una condicion que si restarSaludZombie es mayor que 0 imprime un mensaje y se le resta vida */
        if (restarSaludZombie > 0) {
            System.out.println("Al zombie se le resta " + restarSaludZombie + " de daño.");
            z1.recibeDanyo(restarSaludZombie);
            System.out.println("La vida del zombie ahora es de " + z1.getSalut() + ".");
            /*Si es menor o igual que 0 imprimira otro mensaje y no se le resta vida al zombie */
        } else {
            System.out.println("El zombie se ha defendido a la perfeccion, no recibe daño.");
        }

        /*Ataque del zombie */

        /*Si la vida del zombie es mayor que 0 atacara al superviviente */
        if (z1.getSalut() > 0) {
            System.out.println("======================================================================");
            /*En la variable que antes hemos creado metemos el valor del ataque del zombie y la defensa del superviviente */
            restarSaludSuperviviente = z1.ataca() - s1.defensat();
            /*Creamos una condicion que si restarSaludSuperviviente es mayor que 0 imprime un mensaje y se le resta vida */
            if (restarSaludSuperviviente > 0) {
                System.out.println("Al superviviente se le resta " + restarSaludSuperviviente + " de daño.");
                s1.recibeDanyo(restarSaludSuperviviente);
                System.out.println("La vida del superviviente ahora es de " + s1.getSalut() + ".");
                 /*Si es menor o igual que 0 imprimira otro mensaje y no se le resta vida al superviviente */
            } else {
                System.out.println("El superviviente se ha defendido a la perfeccion, no recibe daño.");
            }
            /*Si el zombie esta muerto no podra atacar y imprimiremos otro mensaje */
        }else{
            System.out.println("El zombie ha caido no puede atacar");
        }
    }
}