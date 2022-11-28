package learning.Operadores;

public class Opcondicionales {
    public static void main(String[] args) {
        //operador AND
        var a = 11;
        var valorMinimo = 0;
        var valorMaximo = 10;

        var resultado = a >= valorMinimo && a <= valorMaximo;
        System.out.println(resultado);

        if (resultado) {
            System.out.println("esta en el rango");
        } else {
            System.out.println("esta fuera del rango");
        }

        //operador OR
        var vacacinones = true;
        var diaDescansio = false;

        if (vacacinones || diaDescansio) {
            System.out.println("si pude ir");
        } else {
            System.out.println("no puede ir");
        }
    }
}
