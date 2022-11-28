package learning.Operadores;

public class igualdadyRelacion {
    public static void main(String[] args) {
        //operador de igualdad
        var a = 3;
        var b = 2;
        var c = a == b;
        System.out.println(c);

        var d = a != b;
        System.out.println(d);

        var cadena1 = "Hola";
        var cadena2 = "Adios";
        var e = cadena1 == cadena2;//compara la referencia de objetos
        System.out.println(e);
    
        var f = cadena1.equals(cadena2);//comprarmos contenido de cadenas
        System.out.println(f);


        //operadores relacionales
        var g = a >= b;
        System.out.println(g);

        if (a % 2 == 0) {
            System.out.println("numero par");
        }else{
            System.out.println("numero impar");
        }

        var edad = 12;
        var adulto = 18;
        if (edad >= adulto) {
            System.out.println("es un adulto");
        } else {
            System.out.println("es un niño");
        }
    }
}
