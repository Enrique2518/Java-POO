package com.example.FueraDeClase.ClaseEjercicio1;

public class Perro extends Animal{


    public Perro(double peso) {
        super(peso);
    }

    @Override
    public void hazRuido(){
        System.out.println("El perro ladra.");
    }
    

}
