package domain;

public class PersonaDTO {
    private int Id;
    private String nombre;
    private String apellido;
    private String email;
    private String numero;

    public PersonaDTO() {
    }

    public PersonaDTO(int Id) {
        this.Id = Id;
    }

    public PersonaDTO(String nombre, String apellido, String email, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
    }

    public PersonaDTO(int Id, String nombre, String apellido, String email, String numero) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", numero=" + numero + '}';
    }
    
}
