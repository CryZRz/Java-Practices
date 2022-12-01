import java.util.Date;

public class ClienteHerencia extends PersonaHerencia {
    private int idCliente;
    private Date fechaRegistro = new Date();
    private boolean vip;

    private static int contadorCliente;

    public ClienteHerencia(String nombre, char genero, int edad, String direccion, boolean vip){
        super(nombre, genero, edad, direccion);
        this.vip = vip;
        ClienteHerencia.contadorCliente++;
        this.idCliente = ClienteHerencia.contadorCliente;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean getVip() {
        return this.vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

}
