package learning.Operadores;

public class aritmeticos {
    public static void main(String[] args) {
        int a = 3, b = 2;
        //suma
        var resultadoSuma = a + b;
        System.out.println(resultadoSuma);

        //resta
        var resultadoResta = a - b;
        System.out.println(resultadoResta);

        //multiplacacion
        var resultadoMultiplicacion = a * b;
        System.out.println(resultadoMultiplicacion);

        //division
        var resultadoDivision = 3 / b;
        System.out.println(resultadoDivision);

        //modulo
        var resultadoModulo = a % b;
        System.out.println(resultadoModulo);

        //si solo hay una linea podemos eviatr las llaves
        if (b % 2 == 0)
            System.out.println("es par");
        else
            System.out.println("es impar");
    }
}
