package com.example.FueraDeClase.ClaseEjercicio3;

public class cotxe extends vehicle implements Conduir, Habilitat{

    private int capacitat;

    public cotxe(String nom, int capacitat){
        super(nom);
        this.capacitat = capacitat;
    }

    @Override
    public void albergarPersones() {
        if (capacitat > 5) {
            System.out.println("No es posible meter a tanta gente el en cotxe. Pondremos solo 5 personas.");
        }else{
            System.out.println("En el cotxe se han albergado " + capacitat + " personas.");
        }
    }

    @Override
    public int obtenirCapacitat() {
        return capacitat;
    }

    @Override
    public void conduir() {
        System.out.println("Estas conduint un cotxe. la save velocitat maxima es de " + obtenirVelocitatMaxima() + ".");
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 200;
    }

    

}
