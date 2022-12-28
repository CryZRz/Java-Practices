public class App {
    public static void main(String[] args) throws Exception {
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica(15);
        objetoInt.obtenerTipo();
        ClaseGenerica<String> objetoString = new ClaseGenerica("Jimena");
        objetoString.obtenerTipo();
    }
}
