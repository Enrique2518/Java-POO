package es.cide.dam.programacio.yaaz;

/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/

import java.util.Random;

/*Creamos una clase armaDeAcero que extiende de nuestra clase artefactes */
public class armaDeAcer extends artefactes{

    /*Creamos un nuevo constructor de armaDeAcer donde solo le pasaremos por parametro el pes*/
    public armaDeAcer(int pes){
        /*LLamamos a la variable pes de la clase superpadre */
        super(pes);
        /*Creamos una cariable rand que nos generara un numero random */
        Random rand = new Random();
        /*Creamos una nueva variable que tendra como valor un numero entre 1 y 15 */
        int valor = 1 + rand.nextInt(15); 
        /*Este método establece el valor de un atributo de la clase armaDeAcer */
        setValorArtefacte(valor);
    }

}
