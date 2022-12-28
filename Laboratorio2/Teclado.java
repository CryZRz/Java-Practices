public class Teclado extends TipoEntrada{
    private int idTeclado;
    private static int contadorTeclado;

    public Teclado(String entrada, String marca){
        super(entrada, marca);
        this.idTeclado = ++Teclado.contadorTeclado;
    }

    public String toString(){
        return "id teclado: " + this.idTeclado + "contador teclado: " + Teclado.contadorTeclado;
    }

}
