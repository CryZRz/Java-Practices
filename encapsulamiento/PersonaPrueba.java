import learning.encapsulamiento.PersonaEnc;

public class PersonaPrueba {
    public static void main(String[] args) {
        PersonaEnc persona1 = new PersonaEnc("christian", 5000.00, false);
        System.out.println(persona1);
        persona1.setNombre("Jimena");
        //System.out.println(persona1.getNombre());
        //System.out.println(persona1.getSueldo());
        //System.out.println(persona1.isEliminado());
        System.out.println(persona1);
    }
}
