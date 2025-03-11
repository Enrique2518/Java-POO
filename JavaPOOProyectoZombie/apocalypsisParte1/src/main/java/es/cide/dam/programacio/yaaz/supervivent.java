package es.cide.dam.programacio.yaaz;

public class supervivent {

    private int salut;
    private int ataque;
    private int defensa;
    private String nom;


    public supervivent() {
        salut = 100;
        ataque = 10;
        defensa = 10;
    }

    public int ataca(){
        int ataqueDelSuperviviente = (int)(Math.random() * ataque);
        System.out.println("El superviviente " + getNom() + " ataca con " + ataqueDelSuperviviente + " de daño.");
        return ataqueDelSuperviviente;
    }

    public int defensat(){
        int defensaDelSupervivent = (int)(Math.random() * defensa);
        System.out.println("El superviviente " + getNom() + "  se defiende con " + defensaDelSupervivent + " de defensa.");
        return defensaDelSupervivent;
    }

    public void recibeDanyo(int quitarVida){
        salut = salut - quitarVida;
    }

    public int getSalut() {
        return this.salut;
    }

    public void setSalut(int salut) {
        this.salut = salut;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
