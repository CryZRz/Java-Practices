package paquete2;

import paquete1.Clase1;

public class ClaseHija extends Clase1{
    public ClaseHija(){
        super("Tkm");
        this.atributoProtected = "modificando atributo protected";
        this.metodoProtected();
    }
}
