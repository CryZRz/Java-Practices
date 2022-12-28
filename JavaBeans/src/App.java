public class App {
    public static void main(String[] args)  {
        Persona persona = new Persona();
        persona.setNombre("jimena");
        persona.setApellido("ramos");
    
        System.out.println(persona.getNombre() + " " + persona.getApellido());

    }
}
