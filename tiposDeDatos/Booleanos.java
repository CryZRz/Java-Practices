package learning.tiposDeDatos;

public class Booleanos {
    public static void main(String[] args) {
        //boleanos True o False
        boolean varBoolean = true;
        System.out.println(varBoolean);

        if (varBoolean) {
            System.out.println("la variable es verdadera");
        } else {
            System.out.println("la variable es falsa");
        }

        var edad = 10;

        if (edad >= 18) {
            System.out.println("es mayor de edad");
        } else {
            System.out.println("es menor de edad");
        }
    }
}
