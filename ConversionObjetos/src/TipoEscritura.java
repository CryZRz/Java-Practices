public enum TipoEscritura {
    CLASICO("Escritura a mano"),
    MORDERNO("escritura digital");

    private final String descripcion;

    private TipoEscritura(String descripcion){
        this.descripcion = descripcion;
    }

    public String descripcion(){
        return this.descripcion;
    }

}
