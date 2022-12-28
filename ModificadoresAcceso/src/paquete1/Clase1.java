package paquete1;
public class Clase1 {
    public String atributoPublico = "hola";
    protected String atributoProtected = "hola2";

    //public Clase1(){
    //    System.out.println("constructor publico");
    //}

    protected Clase1(){
        System.out.println("constructor protected");
    }

    public Clase1(String nombre){
        System.out.println("constructor publico con argumento");
    }

    public void metodoPublico(){
        System.out.println("metodo protected");
    }

    protected void metodoProtected(){
        System.out.println("metodo protected");
    }

}