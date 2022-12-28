public class Persona {
    private final int idPersona;
    private static int contadorPersonas;

    //bloque de inicializacion estico
    static{
        System.out.println("ejecucion bloque estatico");
        ++Persona.contadorPersonas;
    }

    //bloque de inicializacion no estico
    {
        System.out.println("ejecucion bloque no estatico");
        this.idPersona = Persona.contadorPersonas;
    }

    public Persona(){
        System.out.println("la ejecucion del constructor");
    }

    public int getIdPersona(){
        return this.idPersona;
    } 

}
