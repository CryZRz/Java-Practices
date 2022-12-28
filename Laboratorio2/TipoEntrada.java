public class TipoEntrada {
    protected String tipoEntrada;
    protected String marca;

    public TipoEntrada(String entrada, String marca){
        this.tipoEntrada = entrada;
        this.marca = marca;
    }

    public String getTipoEntrada() {
        return this.tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}