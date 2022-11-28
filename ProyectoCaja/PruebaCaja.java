public class PruebaCaja {
    public static void main(String[] args) {
        //caja constructor 1
        Caja caja1 = new Caja();
        caja1.acho = 3;
        caja1.alto = 2;
        caja1.profundidad = 6;
        var resultadoCaja1 = caja1.calcularVolumen();
        System.out.println(resultadoCaja1);

        Caja caja2 = new Caja(3, 2, 6);
        var resultadoCaja2 = caja2.calcularVolumen();
        System.out.println(resultadoCaja2);

    }
}
