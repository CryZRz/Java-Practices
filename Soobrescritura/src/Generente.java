public class Generente extends Empleado{
    
    private String departamento;

    public Generente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    @Override
    public String obtenerDetalles(){
        return super.obtenerDetalles() + " departamento: " + this.departamento;
    }

}
