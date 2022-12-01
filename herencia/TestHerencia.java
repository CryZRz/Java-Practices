public class TestHerencia {
    public static void main(String[] args) {
        EmpleadoHerencia empleado1 = new EmpleadoHerencia("Christian", 5200.00);
        System.out.println(empleado1);

        ClienteHerencia clinete1 = new ClienteHerencia("jimena", 'f', 18, "rio mayo", true);
        System.out.println(clinete1.getIdCliente());
        System.out.println(clinete1.getNombre());
        System.out.println(clinete1.getGenero());
        System.out.println(clinete1.getDireccion());
        System.out.println(clinete1.getVip());
        System.out.println(clinete1.getFechaRegistro());

        ClienteHerencia clinete2 = new ClienteHerencia("Christian", 'm', 18, "rio mayo", false);
        System.out.println(clinete2.getIdCliente());
        System.out.println(clinete2.getNombre());
        System.out.println(clinete2.getGenero());
        System.out.println(clinete2.getDireccion());
        System.out.println(clinete2.getVip());
        System.out.println(clinete2.getFechaRegistro());
    }
}
