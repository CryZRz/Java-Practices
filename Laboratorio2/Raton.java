public class Raton extends TipoEntrada{
    private int idRaton;
    private static int contadorRaton;

    public Raton(String entrada, String marca){
        super(entrada, marca);
        this.idRaton = ++Raton.contadorRaton;
    }

    public String toString(){
        return "id raton: " + this.idRaton + "contador raton: " + Raton.contadorRaton;
    }

}  
