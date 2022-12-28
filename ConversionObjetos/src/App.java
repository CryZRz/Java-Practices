public class App {
    public static void main(String[] args)  {
        Empleado empleado;

        empleado = new Escritor("Juan", 12580, TipoEscritura.CLASICO);
        //System.out.println(empleado);


        System.out.println(empleado.obtenerDetalles());
        
        //downcasting
        Escritor escritor = (Escritor) empleado;
        System.out.println(((Escritor)empleado).getTipoEscritura());

        //upcasting
        Empleado empleado2 = escritor;

    }

}
