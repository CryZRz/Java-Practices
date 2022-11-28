public class PalabraThis {
    public static void main(String[] args) {
        Persona persona = new Persona("Jimena", "Navarro");
        System.out.println(persona);
        System.out.println(persona.nombre);
        System.out.println(persona.apellidos);
    }
}

class Persona {
    String nombre;
    String apellidos;

    Persona(String nombre, String apellidos){
        //super() llamada al constructor de la clase Padre Object
        this.nombre = nombre;
        this.apellidos = apellidos;
        System.out.println("objeto persona usnado this" + this);

        new Imprimir().imprimir(this);

    }

}

class Imprimir {
    public void imprimir(Persona persona ){
        System.out.println("persina desde imprimir " + persona);
        System.out.println("imprimir el objeto actual (this)" + this);
    }
}
