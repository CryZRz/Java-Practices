public class Aritmetica {
    public static int division(int x, int y) /*throws OperacionExecpcion*/ { //prosiblemente arrojara una excepcion
        if (y == 0) {
            throw new OperacionExecpcion("division entre 0 :)");
        }

        return x / y;
    }
}
