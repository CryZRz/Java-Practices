import learning.PalabraFinal.PersonaFinal;

public class TestFinal {
    public static void main(String[] args) {
        final int miVariable = 10; //iguala al const de javascript
        System.out.println(miVariable);
        System.out.println(PersonaFinal.PI);

        final PersonaFinal persona1 = new PersonaFinal();
        persona1.setNombe("christian");
        System.out.println(persona1.getNombe());
        persona1.setNombe("Sergio");
        System.out.println(persona1.getNombe());
    }
}
