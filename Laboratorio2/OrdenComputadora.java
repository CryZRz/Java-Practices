public class OrdenComputadora {
    private int idOrden;
    private ComputadoraLab computadoras[];
    private static int contadorComputadoras;
    private int contadorOrdenes;
    private static final int maxComputadoras = 10;

    public OrdenComputadora(){
        this.idOrden = ++OrdenComputadora.contadorComputadoras;
        this.computadoras = new ComputadoraLab[OrdenComputadora.maxComputadoras];
    }

    public void agregar(ComputadoraLab computadora){
        if (this.contadorOrdenes < OrdenComputadora.maxComputadoras) {
            this.computadoras[this.contadorOrdenes++] = computadora;
        } else {
            System.out.println("maximo de ordenes alcanzado");
        }
    }

    public String mostrarOrden(){
        return "id orden: " + this.idOrden;
    }

}
