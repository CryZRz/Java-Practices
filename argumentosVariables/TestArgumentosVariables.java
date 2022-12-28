public class TestArgumentosVariables {
    public static void main(String[] args) {
        imprimirNumero(3, 12, 7, 1);
        imprimirNumero(3, 4, 5, 6);

        variosParametros("Jimena", 1, 3, 15, 56, 10, 18);
    }

    private static void variosParametros(String nombre, int... numeros){
        System.out.println(nombre);
        imprimirNumero(numeros);
    }

    private static void imprimirNumero(int... numeros){
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }

}
