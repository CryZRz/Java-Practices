package learning.Condicionales;

public class IfElse {
    public static void main(String[] args) {
        var condicion = true;
        if (condicion) {
            System.out.println("condicion verdadera");
        } else {
            System.out.println("condicion falsa");
        }

        var numero = 1;
        if (numero == 1) {
            System.out.println("numeor 1");
        } 
        else if(numero == 2){
            System.out.println("numero 2");
        }
        else if(numero == 3){
            System.out.println("numero 3");
        }else {
            System.out.println("numero desconocido");
        }
    }
}
