package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
public class ciutat {

    /*Creamos sus atributos */
    private String nom;
    private int tamany;
    zombie ruta[];

    /*Creamos su constructor donde le pasaremos como pararametros solo su tamany*/
    public ciutat(int tamany) {
        this.tamany = tamany;
        /*El array de zombies con nombre ruta sera un array de zombies con un espacio que sera igual que tamany */
        this.ruta = new zombie[tamany];
        /*En el constructor recorreremos el array creando en cada una de las posiciones un nuevo zombie */
        for (int i = 0; i < tamany; i++) {
            ruta[i] = new zombie();
        }
    }
    
    /*Creamos los getters y los setters de ciutat */
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

    /*Creamos el metodo devuelve zombie donde nos devolvera el zombie que hay en la ruta indicada */
    public zombie devuelveZombie(int posicionRuta){
        return ruta[posicionRuta];
    }

}
