package com.example.FueraDeClase.ClaseEjercicio1;

public class Animal {

    private double peso;


    public Animal(double peso) {
        this.peso = peso;
    }


    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void hazRuido(){
        System.out.println("El animal hace un ruido.");
    }

}
