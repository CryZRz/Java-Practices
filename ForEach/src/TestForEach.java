public class TestForEach {
    public static void main(String[] args)  {
        int edades[] = {5, 6, 8, 9}; //no se puede usar var en arreglos

        for (int edad : edades) {
            System.out.println(edad);
        }

        Persona personas[] = {new Persona("Jimena"), new Persona("Christian"), new Persona("Travis")};
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        
    }
}
