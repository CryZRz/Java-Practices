package learning.bucles;

import javax.naming.InitialContext;

public class etiquetas {
    public static void main(String[] args) {
        inicio:
        for (int i = 1; i < 5; i++) {
            if (i % 2 != 0) {
               continue inicio; //ir a la linea de codigo de la etiqueta
            }
            System.out.println(i);
        }
    }
}
