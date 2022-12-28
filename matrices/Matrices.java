public class Matrices {
    public static void main(String[] args) {
        int edades[][] = new int[3][2];

        System.out.println(edades);

        edades[0][0] = 25;
        edades[0][1] = 7;

        edades[1][0] = 8;
        edades[1][1] = 3;

        edades[2][0] = 12;
        edades[2][1] = 18;

        System.out.println(edades[0][0]);

        for (int i = 0; i < edades.length; i++) {
            for (int j = 0; j < edades[i].length; j++) {
                System.out.println(edades[i][j]);
            }
        }

        String frutas[][] = {{"limon", "naranja"}, {"piña", "pera"}};
        
        for (int i = 0; i < frutas.length; i++) {
            for (int j = 0; j < frutas[i].length; j++) {
                System.out.println(frutas[i][j]);
            }
        }

        PersonaMatrices personas[][] = new PersonaMatrices[2][3];

        personas[0][0] = new PersonaMatrices("Jimena");


    }
}
