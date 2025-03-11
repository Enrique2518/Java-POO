package com.example.FueraDeClase.ClaseEjercicio2;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU3EX01			    */
/****************************************/

public class App {

    //creamos el metodo main
    public static void main(String[] args) {

        //Creamos tres herramientas pero diferentes tipos de herramientas.
        Eina martell = new Martell( 1.5, "Metall");
        Eina destornillador = new Destornillador(0.7, "Acer");
        Eina serra = new Serra(2.3, "Fusta");

        //Imprimimos por pantalla la información de cada una de las herramientas
        mostrarEina(martell);
        mostrarEina(destornillador);
        mostrarEina(serra);

    }

    //Creamos el metodo static mostrar eina
    public static void mostrarEina(Eina unaEina){
        //Imprimimos por pantalla el nombre de la eina, el peso y de que material esta fabricado
        System.out.println("Nom: " + unaEina.getNom() + ", Pes: " + unaEina.getPes() + ", Material: " + unaEina.getMaterial());
        System.out.println("-----------------------------------------");
    }

}
