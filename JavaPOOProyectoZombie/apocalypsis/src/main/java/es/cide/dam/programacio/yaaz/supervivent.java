package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
/*Creamos la clase superviviente */
public class supervivent {

    /*Creamos sus atributos */
    private int salut;
    private double ataque;
    private double defensa;
    private String nom;

    /*Creamos un constructor con parametros ya definidos */
    public supervivent() {
        salut = 100;
        ataque = 10;
        defensa = 10;
    }

    /*Creamos un metodo atacar que devolvera un valor numerico */
    public int ataca(){
        /*Generamos un numero aleatorio entre 0 y 10 */
        int ataqueDelSuperviviente = (int)(Math.random() * ataque);
        System.out.println("El superviviente " + getNom() + " ataca con " + ataqueDelSuperviviente + " de daño.");
        return ataqueDelSuperviviente;
    }

    /*Creamos un metodo defender que devolvera un valor numerico */
    public int defensat(){
        /*Generamos un numero aleatorio entre 0 y 10 */
        int defensaDelSupervivent = (int)(Math.random() * defensa);
        System.out.println("El superviviente " + getNom() + "  se defiende con " + defensaDelSupervivent + " de defensa.");
        return defensaDelSupervivent;
    }

    /*Creamos un metodo que no nos devolvera nada pero es para quitarle vida a nuestro superviviente*/
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

    public double getAtaque() {
        return this.ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefensa() {
        return this.defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*Generamos metodos diferentes donde le pasamos un artefacto pero depende de cada artefacto hara una funcion u otra*/

    /*Metodo para multiplicar el ataque*/
    public void aumentoAtaqueMultiplicado(artefactes a1){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Ataque actual: " + ataque);
        System.out.println("Multiplicamos el ataque con " + a1.getValorArtefacte());
        ataque = ataque + (ataque * a1.getValorArtefacte());
        System.out.println("Ataque modificado: " + ataque);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /*Metodo para aumentarle el ataque al superviviente*/
    public void aumentoAtaqueSumar(artefactes a1){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Ataque actual: " + ataque);
        System.out.println("Aumentamos el ataque con " + a1.getValorArtefacte());
        ataque = ataque + a1.getValorArtefacte();
        System.out.println("Ataque modificado: " + ataque);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /*Metodo para aumentarle la vida al superviviente*/
    public void auemntoSalud(artefactes a1){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Salud actual: " + salut);
        System.out.println("Aumentamos nuestra salud con " + a1.getValorArtefacte());
        salut = (int) (salut + a1.getValorArtefacte());
        System.out.println("Salud modificado: " + salut);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /*Metodo para aumentar la defensa del superviviente*/
    public void aumentoDefensa(artefactes a1){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Defensa actual: " + defensa);
        System.out.println("Mejoramos nuestra defensa con " + a1.getValorArtefacte());
        defensa = defensa + (defensa * a1.getValorArtefacte());
        System.out.println("Salud modificado: " + defensa);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


}
