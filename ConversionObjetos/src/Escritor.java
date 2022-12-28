public class Escritor extends Empleado {
    
    final TipoEscritura tipoEscritura;

    public Escritor(String nombre, double suledo, TipoEscritura escritura){
        super(nombre, suledo);
        this.tipoEscritura = escritura;
    }

    public TipoEscritura getTipoEscritura(){
        return this.tipoEscritura;
    }
    
    @Override
    public String obtenerDetalles(){
        return super.obtenerDetalles() + " tipo de escritura: " + tipoEscritura.descripcion();
    }

    @Override
    public String toString(){
     return "tipo de escritura " + this.tipoEscritura + super.toString();   
    }

}
