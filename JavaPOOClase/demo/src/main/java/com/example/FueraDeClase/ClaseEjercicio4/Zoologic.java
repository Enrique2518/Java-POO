package com.example.FueraDeClase.ClaseEjercicio4;

public class Zoologic {

    private int tamany;
    private Animal tamanyZoologic[];

    public Zoologic(int tamany) {
        this.tamany = tamany;
        tamanyZoologic = new Animal[tamany];
        for (int i = 0; i < tamany; i++) {
            int numeroRan = (int) ((Math.random() * 3) + 1);
            switch (numeroRan) {
                case 1:
                    tamanyZoologic[i] = new Gos();
                    break;
                case 2:
                    tamanyZoologic[i] = new Aguila();
                    break;
                case 3:
                    tamanyZoologic[i] = new Peix();
                    break;
            }
        }
    }

    public void mostrarAnimales(){
        Gos g1 = new Gos();
        Aguila a1 = new Aguila();
        Peix p1 = new Peix();
        for (int i = 0; i < tamany; i++) {
            System.out.println("============================");
            if (tamanyZoologic[i] instanceof Gos) {
                g1.mostrarInformacio();
                g1.emetreSo();
                g1.caminar();
            }else if (tamanyZoologic[i] instanceof Aguila) {
                a1.mostrarInformacio();
                a1.emetreSo();
                a1.volar();
            }else if (tamanyZoologic[i] instanceof Peix) {
                p1.mostrarInformacio();
                p1.emetreSo();
                p1.nedar();
            }
        }
    }

    public int getTamany(){
        return tamany;
    }

}
