package com.example.FueraDeClase.ClaseEjercicio2;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU3EX01			    */
/****************************************/

//Creamos la clase Martell que sera una clase hija de Eina
public class Martell extends Eina{

    //Creamos su constructor con los atributos de la clase padre Eina con el super
    public Martell(double pes, String material) {
        super(pes, material);
    }

    //Sobreescribimos el método utilizar de la clase Eina para si creeamos un martillo el metodo utilizar nos imprima este mensaje.
    @Override
    public void utilitzar(){
        System.out.println("Colpejant amb el martell.");
    }

    //Sobreescribimos el método getNom(Para conseguir el nombre) de la clase Eina para si creeamos un martillo el metodo utilizar nos imprima este mensaje.
    @Override
    public String getNom(){
        return "Martell";
    }
    
}
