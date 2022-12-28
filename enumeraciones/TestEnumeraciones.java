public class TestEnumeraciones {
    public static void main(String[] args) {
        System.out.println("dia uno de la semana" + Dias.LUNES);
        indicarDia(Dias.LUNES);
    }

    private static void indicarDia(Dias dias){
        switch (dias) {
            case LUNES:
                System.out.println("lunes");
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
