package es.cide.dam.programacio.yaaz;
/****************************************/
    /* Nom: Enrique Muñoz-Torrero Rodriguez	*/
    /* DNI/NIE: 43235257H 			        */
    /* Data: 10/10/2024 				    */
    /* Exercici: PROU2EX02				    */
/****************************************/
/*Creamos una clase SuperZombie que extendera de la superclase zombie*/
public class superZombie extends zombie{

    /*Creamos un constructor de superzombie y los valores de este seran X3 y X2 de los zombies normales*/
    public superZombie(){
        super();
        setSalut(getSalut() * 3);
        setAtaque(getAtaque() * 2);
        setDefensa(getDefensa());
    }

}
