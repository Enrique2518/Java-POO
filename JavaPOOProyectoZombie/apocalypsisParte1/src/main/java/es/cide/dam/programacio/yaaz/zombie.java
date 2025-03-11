package es.cide.dam.programacio.yaaz;

public class zombie {

    private int salut;
    private int ataque;
    private int defensa;

    public zombie() {
        salut = 20;
        ataque = 5;
        defensa = 5;
    }

    public int ataca(){
        int ataqueZombie = (int)(Math.random() * ataque);
        System.out.println("El zombie ataca con " + ataqueZombie + " de daño.");
        return ataqueZombie;
    }

    public int defensat(){
        int defensaZombie = (int)(Math.random() * defensa);
        System.out.println("El zombie se defiende con " + defensaZombie + " de defensa.");
        return defensaZombie;
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

}
