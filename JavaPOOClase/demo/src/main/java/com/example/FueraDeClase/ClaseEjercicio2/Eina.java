package com.example.FueraDeClase.ClaseEjercicio2;

/****************************************/
/* Nom: Enrique Muñoz-Torrero Rodriguez	*/
/* DNI/NIE: 43235257H 			        */
/* Data: 10/10/2024 				    */
/* Exercici: PROU3EX01			    */
/****************************************/

//Creamos la clase abstracta Eina
abstract class Eina {

    //creamos sus atributos
    private double pes;
    private String material;

    //creamos su cosntructor que inicialice sus atributos
    public Eina(double pes, String material) {
        this.pes = pes;
        this.material = material;
    }


    //Creamos getters y setters de peso y material
    public double getPes() {
        return this.pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //creamos el metodo abstracto utilizar para que lo hereden las clases hijas
    abstract void utilitzar();

    //creamos el metodo abstracto utilizar para que lo hereden las clases hijas
    abstract String getNom();

}
