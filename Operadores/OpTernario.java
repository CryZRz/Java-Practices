package learning.Operadores;

public class OpTernario {
    public static void main(String[] args) {
        var resultado = 3 > 2 ? "verdadero" : "falso";
        System.out.println(resultado);

        var numero = 9;
        resultado = numero % 2 == 0 ? "es par" : "es impar";
        System.out.println(resultado);
    }
}
