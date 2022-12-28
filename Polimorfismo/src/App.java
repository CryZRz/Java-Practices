public class App {
    public static void main(String[] args)  {
        Empleado empleado = new Empleado("Chris", 12589);
        //System.out.println(empleado.obtenerDetalles());

        empleado = new Generente("Karla", 1000, "Contabilidad");
        //System.out.println(generente.obtenerDetalles());
        imprimir(empleado);

    }

    public static void imprimir(Empleado empleado){
        System.out.println(empleado.obtenerDetalles());
    }

}
