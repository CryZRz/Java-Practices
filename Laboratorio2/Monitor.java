public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamaño;
    private static int contadorMonitores;

    private Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }

    public Monitor(String marca, double tamaño){
        this();
        this.marca = marca;
        this.tamaño = tamaño;
    }

    public int getIdMonitor() {
        return this.idMonitor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamañO() {
        return this.tamaño;
    }

    public void setTamañO(double tamaño) {
        this.tamaño = tamaño;
    }

    public int getInt() {
		return Mtinor.contadorMonitores;
	}

    public String toString(){
        return "id monitor" + this.idMonitor + "maraca: " + this.marca + "tamaño" + this.tamaño;
    }
}
