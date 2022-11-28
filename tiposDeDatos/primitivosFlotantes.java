package learning.tiposDeDatos;

public class primitivosFlotantes {
    public static void main(String[] args) {
        /*
         * tipos primitivos de tipo flotante: float, double
         */

         //float: 32bits
         //por defecto en java las variables de tipo flotante son double
         float numeroFloat = 3.4028235E38F;
         System.out.println(numeroFloat);
         System.out.println("valor minino tipo float: " + Float.MIN_VALUE);
         System.out.println("valor maximo tipo float: " + Float.MAX_VALUE);

         //double: 64bits
         double numeroDouble = 1.7976931348623157E308;
         System.out.println(numeroDouble);
         System.out.println("valor minino tipo Double: " + Double.MIN_VALUE);
         System.out.println("valor maximo tipo Double: " + Double.MAX_VALUE);
    }
}
