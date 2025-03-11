package com.example.FueraDeClase.ClaseEjercicio4;

public abstract class Animal {

    private String nom;
    private String tipus;

    private int contador = 0;


    public Animal(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
        contador++;
    }

    public void mostrarInformacio(){
        System.out.println("Animal: " + nom + " " + contador + ", Tipus: " + tipus + ".");
    }

    abstract void emetreSo();


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return this.tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


}
