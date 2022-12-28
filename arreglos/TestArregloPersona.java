public class TestArregloPersona {
    public static void main(String[] args) {
        PersonaMatrices personas[] = new PersonaMatrices[2];

        personas[0] = new PersonaMatrices("Christian");
        personas[1] = new PersonaMatrices("Jiemna");

        System.out.println(personas[0]);
        System.out.println(personas[1]);

        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i].getNombre());
        }

        String frutas[] = {"naranja", "limon", "uva"};

        for (int i = 0; i < frutas.length; i++) {
            System.out.println(frutas[i]);
        }

    }
}