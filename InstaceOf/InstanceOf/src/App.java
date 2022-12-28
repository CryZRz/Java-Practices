public class App {
    public static void main(String[] args)  {
        Empleado empleado = new Empleado("Chris", 12589);
        //determinarTipo(empleado);

        empleado = new Generente("Karla", 1000, "Contabilidad");
        determinarTipo(empleado);
    }

    public static void determinarTipo(Empleado empleado){
        if (empleado instanceof Generente) {
            System.out.println("es de tipo gerente");
            Generente generente = (Generente)empleado;
            //((Generente) empleado).getDepartamento();
            System.out.println(generente.getDepartamento());
        }
        else if (empleado instanceof Empleado) {
            System.out.println("es de tipo empleado");
        }
        else if (empleado instanceof Object) {
            System.out.println("es de tipo object");
        }
    }

}
