package domain;

public class Usuario {
    private int id;
    private String name;
    private String password;

    public Usuario(int id){
        this.id = id;
    }

    public Usuario(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Usuario(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "id: " + this.id + " nombre: " + this.name + " password: " + this.password;
    }
    
}
