package com.example.FueraDeClase.ClaseEjercicio3;

public abstract class vehicle {

    private String nom;


    public vehicle(String nom) {
        this.nom = nom;
    }

    public void descriure(){
        System.out.println("Soc un vehicle. Em dic " + nom + ".");
    }

}
