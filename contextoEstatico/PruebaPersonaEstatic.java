import learning.contextoEstatico.PersonaEstatic;

public class PruebaPersonaEstatic {

    private int contador;

    public static void main(String[] args) {
        PersonaEstatic personaEstatica = new PersonaEstatic("Christian");
        PersonaEstatic personaEstatica2 = new PersonaEstatic("Jimena");

        imprimir(personaEstatica2);
        imprimir(personaEstatica);
    }

    public static void imprimir(PersonaEstatic persona){
        System.out.println(persona);
    }

    public int getContador(){
        imprimir(new PersonaEstatic("Alan"));
        return this.contador;
    }

}


