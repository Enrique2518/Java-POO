package com.example.FueraDeClase.ClaseEjercicio2;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU3EX01			    */
/****************************************/

//Creamos la clase Serra que sera una clase hija de Eina
public class Serra extends Eina{

    //Creamos su constructor con los atributos de la clase padre Eina con el super
    public Serra(double pes, String material) {
        super(pes, material);
    }

    //Sobreescribimos el método utilizar de la clase Eina para si creeamos una serra el método utilizar nos imprima este mensaje.
    @Override
    public void utilitzar(){
        System.out.println("Tallant amb la serra.");
    }

    //Sobreescribimos el método getNom(Para conseguir el nombre) de la clase Eina para si creeamos una serra el método utilizar nos imprima este mensaje.
    @Override
    public String getNom(){
        return "Serra";
    }

}
