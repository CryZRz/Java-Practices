public class TestEnumeraciones {
    public static void main(String[] args) {
        //System.out.println("dia uno de la semana " + Enumeraciones.LUNES);
        //indicarDia(Enumeraciones.LUNES);
        System.out.println("contienente numero 4:" + Continentes.AMERICA);
        System.out.println("No paises contienente numero 4: " + Continentes.AMERICA.getPaises());
    }

    private static void indicarDia(Enumeraciones dias){
        switch (dias) {
            case LUNES:
                System.out.println("hola lunes!");
                break;
            case MARTES:
                System.out.println("martes");
                break;
            case MIERCOLES:
                System.out.println("miercoles");
                break;
            case JUEVES:
                System.out.println("jueves");
                break;
            default:
                System.out.println("el dia no existe");
                break;
        }
    }

}
