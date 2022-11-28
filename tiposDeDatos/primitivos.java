package learning.tiposDeDatos;

public class primitivos {
    public static void main(String[] args) {
        /*
         * tipos primitivos enteros: byte, short, int, long
         */
        //byte: 8 bits
        byte numeroByte = (byte)129;
        System.out.println(numeroByte);
        System.out.println("Valor minimo byte" + Byte.MIN_VALUE);
        System.out.println("Valor maximo byte" + Byte.MAX_VALUE);

        //short: 16 bits
        short numeroSort = (short)32768;//(short) froza al compilador a transformarlo en en tipo de dato
        System.out.println(numeroSort);
        System.out.println("Valor minimo short: " + Short.MIN_VALUE);
        System.out.println("Valor maximo short: " + Short.MAX_VALUE);

        //inetegrer: 32 bits
        int numeroInt = (int)21474836475L;
        System.out.println(numeroInt);
        System.out.println("Valor minimo int" + Integer.MIN_VALUE);
        System.out.println("Valor maximo int" + Integer.MAX_VALUE);
    
        //long: 64bits
        long numeroLong = 12;
        System.out.println(numeroLong);
        System.out.println("Valor minimo long" + Long.MIN_VALUE);
        System.out.println("Valor maximo long" + Long.MAX_VALUE);
    
    }
}
