public class ComputadoraLab {
    private final int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Raton raton;
    private Teclado teclado;
    private static int contadorComputadoras;

    private ComputadoraLab(){
        this.idComputadora = ++ComputadoraLab.contadorComputadoras;
    }

    public ComputadoraLab(String nombre, Monitor monitor, Raton raton, Teclado teclado){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.raton = raton;
        this.teclado = teclado;
    }

    public int getIdComputadora() {
        return this.idComputadora;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Raton getRaton() {
        return this.raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    public Teclado getTeclado() {
        return this.teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public String toString(){
        return "id computadora: " + this.idComputadora + "marca: " + this.marca + "monitor: " + this.getMonitor() + "raton: " + this.getRaton() + "teclado: " + this.getTeclado();
    }

}
