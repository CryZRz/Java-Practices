package learning.classesJv;

public class PruebaPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Christian";
        persona1.apellido = "Rms";
        persona1.desplegarInformacion();

        Persona persona2 = new Persona();
        System.out.println(persona1);
        System.out.println(persona2);

        persona2.desplegarInformacion();//si no se asigna nada a los atributos se pone automaticamnete null
        persona2.nombre = "Jimena";
        persona2.apellido = "Navarro";
        persona2.desplegarInformacion();
    }
}
