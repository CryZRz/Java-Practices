public class EmpleadoHerencia extends PersonaHerencia {
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public EmpleadoHerencia(){
        //super();
        EmpleadoHerencia.contadorEmpleado++;
        this.idEmpleado = EmpleadoHerencia.contadorEmpleado;
    }

    public EmpleadoHerencia(String nombre, double sueldo){
        //super(nombre);
        this();
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", Empleado id: ").append(this.idEmpleado);
        sb.append(" Sueldo: ").append(this.sueldo);
        sb.append(", Persona( ").append(super.toString()).append(" )");
        
        return sb.toString();
    }

}
