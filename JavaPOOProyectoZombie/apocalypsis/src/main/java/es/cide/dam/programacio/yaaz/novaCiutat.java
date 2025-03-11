package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
/*Creamos una clase llamada novaCiutat que extiende de ciutat */
public class novaCiutat extends ciutat {

    /*Creamos como atributo un nuevo array de artefactos */
    artefactes cajasArtefacto[];

    /*Creamos un constructor de novaCiutat y solo le pasamos por parametro el tamany */
    public novaCiutat(int tamany) {
        /*Llamamos a tamany con el super por la clase superpadre que es ciutat */
        super(tamany);

        /*El array de zombies con nombre ruta sera un array de zombies con un espacio que sera igual que tamany */
        this.ruta = new zombie[tamany];
        /*En el constructor recorreremos el array creando en cada una de las posiciones un nuevo zombie o un superZombie */
        for (int i = 0; i < tamany; i++) {
            /*Generamos un numero random de entre 1 y 10 */
            int numeroRandom = (int) ((Math.random() * 10) + 1);
            if (numeroRandom == 1) {
                /*Si el numero es igual a 1 se creeara un SuperZombie */
                ruta[i] = new superZombie();
            }else {
                /*Sino se generara un zombie normal */
                ruta[i] = new zombie();
            }
        }

        /*El array de artefactes con nombre cajasArtefacto sera un array de atrefactes con un espacio que sera igual que tamany */
        this.cajasArtefacto = new artefactes[tamany];
        /*En el constructor recorremos el array creando nuevos atrefactos. */
        for (int i = 0; i < tamany; i++) {
            /*Creamos un contador para que solo pueda crear un arma de fuego */
            int contador = 0;
            /*Generamos un numero random y depende del numero que genere sera un tipo de atrefacte diferente */
            int numeroRandom = (int) ((Math.random() * 100) + 1);
            /*Si el numero es igual que 1 y el contador es igual a 0 sera un arma de fuego, si ya ha aparecido una contador sera igual a uno y no apareceran mas armas de fuego */
            if (numeroRandom == 1 && contador == 0) {
                cajasArtefacto[i] = new armaDeFoc(1);
                contador++;
                /*Si el numero es de 11 a 13 sera un arma de acero */
            } else if (numeroRandom >= 11 && numeroRandom <= 13) {
                cajasArtefacto[i] = new armaDeAcer(2);
                /*Si el numero es de 41 y 45 sera una farmaciola */
            } else if (numeroRandom >= 41 && numeroRandom <= 45) {
                cajasArtefacto[i] = new farmaciola(3);
                /*Si el numero es de 91 a 100 sera un escudo */
            } else if (numeroRandom >= 91 && numeroRandom <= 100) {
                cajasArtefacto[i] = new escud(4);
                /*Sino sera un artefacto normal y no tendra ninguna funcion */
            } else {
                cajasArtefacto[i] = new artefactes(5);
            }
        }
    }

    
    /*Creamos el metodo devuelve zombie donde nos devolvera el zombie que hay en la ruta indicada */
    public zombie devuelveZombie(int posicionRuta) {
        return ruta[posicionRuta];
    }

    /*Creamos el metodo que hay en la caja para que nos devuelva que hay en cada posicion de array cuando la recorramos entre los diferentes artefactos que hemos creado. */
    public artefactes obrirEnCasDeEmergencia(int posicionRuta) {
        if (cajasArtefacto[posicionRuta] instanceof armaDeFoc) {
            System.out.println("Ha aparecido un arma de fuego.");
        }else if (cajasArtefacto[posicionRuta] instanceof armaDeAcer) {
            System.out.println("Ha aparecido un arma de acero.");
        }else if (cajasArtefacto[posicionRuta] instanceof farmaciola) {
            System.out.println("Ha aparecido una farmaciola.");
        }else if (cajasArtefacto[posicionRuta] instanceof escud) {
            System.out.println("Ha aparecido un escudo.");
        }else{
            System.out.println("No ha aparecido nada...");
        }
        return cajasArtefacto[posicionRuta];
    }

}
