package com.example.FueraDeClase.ClaseEjercicio3;

public class Ap {

    public static void main(String[] args) {
        
        cotxe c1 = new cotxe("Tesla Model S", 4);

        moto m1 = new moto("Yamaha r1", 3);

        c1.descriure();
        c1.conduir();
        c1.albergarPersones();

        System.out.println("============");

        m1.descriure();
        m1.conduir();
        m1.albergarPersones();
        
    }

}
