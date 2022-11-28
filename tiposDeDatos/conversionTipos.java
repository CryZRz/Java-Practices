package learning.tiposDeDatos;

import java.util.Scanner;

public class conversionTipos {
    public static void main(String[] args) {
        //convertir de tipo string a int
        var edad = Integer.parseInt("20");
        System.out.println(edad);

        var valorPI = Double.parseDouble("3.1416");
        System.out.println(valorPI);

        //pedir un valor
        var consola = new Scanner(System.in);

        // System.out.println("ingresa tu edad");
        // var edad2 = Integer.parseInt(consola.nextLine());
    
        // if (edad2 >= 18) {
        //     System.out.println("eres mayor de edad");
        // } else {
        //     System.out.println("eres menor de edad");
        // }

        //pasar de int a string
        var edadText = String.valueOf(18);
        System.out.println(edadText);

        var caracter = "Jimena".charAt(0);
        System.out.println(caracter);

        System.out.println("ingrese un caracter");
        caracter = consola.nextLine().charAt(0);
        System.out.println("su caracter es: " + caracter);
    }
}
