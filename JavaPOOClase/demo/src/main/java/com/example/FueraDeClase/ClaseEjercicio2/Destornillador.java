package com.example.FueraDeClase.ClaseEjercicio2;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU3EX01			    */
/****************************************/

//Creamos la clase Destornillador que sera una clase hija de Eina
public class Destornillador extends Eina{

    //Creamos su constructor con los atributos de la clase padre Eina con el super
    public Destornillador(double pes, String material) {
        super(pes, material);
    }

    //Sobreescribimos el método utilizar de la clase Eina para si creeamos un destornillador el método utilizar nos imprima este mensaje.
    @Override
    public void utilitzar(){
        System.out.println("Tornant cargols amb el destornillador.");
    }

    //Sobreescribimos el método getNom(Para conseguir el nombre) de la clase Eina para si creeamos un destornillador el método utilizar nos imprima este mensaje.
    @Override
    public String getNom(){
        return "Destornillador";
    }

}
