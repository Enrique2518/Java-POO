package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
/*Creamos la clase superviviente */
public class zombie {

    /*Creamos sus atributos */
    private int salut;
    private int ataque;
    private int defensa;

    /*Creamos un constructor con parametros ya definidos */
    public zombie() {
        salut = 20;
        ataque = 5;
        defensa = 5;
    }

    /*Creamos un metodo atacar que devolvera un valor numerico */
    public int ataca(){
        /*Generamos un numero aleatorio entre 0 y 5 */
        int ataqueZombie = (int)(Math.random() * ataque);
        System.out.println("El zombie ataca con " + ataqueZombie + " de daño.");
        return ataqueZombie;
    }

    /*Creamos un metodo defender que devolvera un valor numerico */
    public int defensat(){
        /*Generamos un numero aleatorio entre 0 y 5 */
        int defensaZombie = (int)(Math.random() * defensa);
        System.out.println("El zombie se defiende con " + defensaZombie + " de defensa.");
        return defensaZombie;
    }
    
    /*Creamos un metodo que no nos devolvera nada pero es para quitarle vida al zombie*/
    public void recibeDanyo(int quitarVida){
        salut = salut - quitarVida;
    }

    /*Creamos los getters y setters de los atributos*/
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
