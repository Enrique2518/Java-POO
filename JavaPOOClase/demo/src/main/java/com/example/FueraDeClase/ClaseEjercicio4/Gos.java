package com.example.FueraDeClase.ClaseEjercicio4;

public class Gos extends Animal implements Terrsestre{

    public Gos(){
        super("Gos", "Mamifer");
    }

    @Override
    public void caminar() {
        System.out.println("El animal esta caminando");
    }

    @Override
    void emetreSo() {
        System.out.println("Bup bup");
    }

}
