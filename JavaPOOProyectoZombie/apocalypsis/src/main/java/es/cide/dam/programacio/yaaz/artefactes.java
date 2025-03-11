package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
/*Creamos una clase artefacte, no la pongo abstract ya que la voy a necesitar crear en mi array en la clase nova ciutat */
public class artefactes {

    /*Creamos sus atributos */
    private int pes;
    private double valorArtefacte;

    /*Creamos su constructor */
    public artefactes(int pes){
        this.pes = pes;
    }

    /*Creamos getters y setters de los atributos para poder modificarlos fuera de la clase */
    public int getPes() {
        return this.pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public double getValorArtefacte() {
        return this.valorArtefacte;
    }

    public void setValorArtefacte(double valorArtefacte) {
        this.valorArtefacte = valorArtefacte;
    }

}
