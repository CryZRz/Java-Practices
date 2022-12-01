public class PersonaEstatic {
    private int idPersona;
    private String nombre;
    private static int contadorPersonas;

    public PersonaEstatic(String nombre){
        this.nombre = nombre;
        PersonaEstatic.contadorPersonas++;
        //asiganar el nuevo valor a la variable idPersona
        this.idPersona = PersonaEstatic.contadorPersonas;
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static getContadorPersonas() {
		return contadorPersonas;
	}

    public void setContadorPersonas(int aContadorPersonas) {
		contadorPersonas = aContadorPersonas;
	}

    public String toString(){
        return "Persona [nombre: " + this.nombre + " idPersona: " + this.idPersona ;
    }
    
}
