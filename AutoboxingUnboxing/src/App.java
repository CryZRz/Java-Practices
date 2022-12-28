public class App {
    public static void main(String[] args) throws Exception {
        //clases envolventes de tipos primitivos
        /*
         * int - Integer
         * long - Long
         * float - Float
         * double - Double
         * boolean - Boolean
         * byte - Byte
         * char - Character
         * short - Short
         */

        Integer entero = 10;//Autoboxing
        System.out.println(entero);
        System.out.println(entero.toString());
        System.out.println(entero.doubleValue());

        int entero2 = entero;//Unboxing
        System.out.println(entero2);

    }
}
