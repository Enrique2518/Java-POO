package com.example.FueraDeClase.ClaseEjercicio4;

public class Aguila extends Animal implements Volador{

    public Aguila(){
        super("Aguila", "Au");
    }

    @Override
    public void volar() {
        System.out.println("Estoy volando");
    }

    @Override
    void emetreSo() {
        System.out.println("Screech");
    }

}
