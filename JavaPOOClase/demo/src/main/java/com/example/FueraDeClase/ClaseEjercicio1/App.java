package com.example.FueraDeClase.ClaseEjercicio1;

public class App {

    public static void main(String[] args) {
        
        Perro p1 = new Perro(20);
        Gato g1 = new Gato(5);

        p1.hazRuido();
        g1.hazRuido();

        System.out.println("El perro pesa: " + p1.getPeso());
        System.out.println("El gato pesa: " + g1.getPeso());

        p1.setPeso(40);
        g1.setPeso(8);

        System.out.println("El perro pesa: " + p1.getPeso());
        System.out.println("El gato pesa: " + g1.getPeso());

    }

}
