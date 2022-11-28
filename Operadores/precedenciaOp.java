package learning.Operadores;

public class precedenciaOp {
    public static void main(String[] args) {
        var x = 5;
        var y = 10;
        var z = ++x + y--;
        System.out.println(z);

        var resultado = 4 + 5 * 6 / 3;//4 + (5*6)/3) == 14
        System.out.println(resultado);

        resultado = (4 + 5) * 6 / 3;//4+5 = (9 *6)/3 = 18
        System.out.println(resultado);

    }
}
