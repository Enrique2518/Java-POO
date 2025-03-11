package com.example.FueraDeClase.ClaseEjercicio4;

public class Peix extends Animal implements Aquatic{

    public Peix(){
        super("Peix", "Aquatic");
    }

    @Override
    public void nedar() {
        System.out.println("Estoy nadando");
    }

    @Override
    void emetreSo() {
        System.out.println("Blub blub");
    }

}
