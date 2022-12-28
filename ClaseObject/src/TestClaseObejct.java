public class TestClaseObejct {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Nacho", 1500);
        Empleado empleado2 = new Empleado("Nacho", 1500);

        if (empleado1 == empleado2) {
            System.out.println("tiene la misma referencia en memoria");
        }else{
            System.out.println("tienen distia referencia en memoria");
        }

        

    }
}
