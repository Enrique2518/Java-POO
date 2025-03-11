package com.example.FueraDeClase.ClaseEjercicio1;

public class Gato extends Animal{

    public Gato(double peso) {
        super(peso);
    }

    @Override
    public void hazRuido(){
        System.out.println("El gato maúlla.");
    }

}
