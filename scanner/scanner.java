package learning.scanner;
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        System.out.println("Escribe tu nombre: ");
        Scanner consola = new Scanner(System.in);
        var usuario = consola.nextLine();

        System.out.println("Hola" + " " + usuario);

        System.out.println("Escribe el titulo");
        var titulo = consola.nextLine();
    
        System.out.println(titulo + " " + usuario);
    }
}
