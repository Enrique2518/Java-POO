package es.cide.dam.programacio.yaaz;

public class ciutat {

    private String nom;
    private int tamany;
    zombie ruta[];


    public ciutat(int tamany) {
        this.tamany = tamany;
        this.ruta = new zombie[tamany];
        for (int i = 0; i < tamany; i++) {
            ruta[i] = new zombie();
        }
    }
    


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTamany() {
        return this.tamany;
    }

    public void setTamany(int tamany) {
        this.tamany = tamany;
    }

    public zombie[] getRuta() {
        return this.ruta;
    }

    public void setRuta(zombie[] ruta) {
        this.ruta = ruta;
    }

    public zombie devuelveZombie(int posicionRuta){
        return ruta[posicionRuta];
    }

}
