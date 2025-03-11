package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
import java.util.Random;
/*Creamos una clase escud que extiende de nuestra clase artefactes */
public class escud extends artefactes{

    /*Creamos un nuevo constructor de escud donde solo le pasaremos por parametro el pes*/
    public escud(int pes){
        /*LLamamos a la variable pes de la clase superpadre */
        super(pes);
        /*Creamos una variable rand que nos generara un numero random */
        Random rand = new Random();
         /*Aqui hay varios pasos
         * 1. se calcula 1.5 - 0.9 que es 0.6
         * 2. rand.nextDouble() genera un número entre 0.0 y 1.0.
         * 3.Lo cual te dara un numero entre 0.0 y 0.6
         * 4.Finalmente ese resultado se sumara a 0.9 lo cual te dara un valor entre 0,9 y 1.5
         * Es decir si el numero te da 0.2 en el paso 3 el resultado final sera de 1.1
         * Porque 0.2 + 0.9 = 1.1
         */
        double valor = 0.9 + (1.5 - 0.9) * rand.nextDouble();
         /*Aqui redondemaos el valor a que tenga un solo decimal */
        valor = Math.round(valor * 10.0) / 10.0;
        /*Este método establece el valor de un atributo de la clase escud */
        setValorArtefacte(valor);
    }

}
