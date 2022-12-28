import learning.Laboratorio2.*;

public class TestComputadora {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("asus", 1920.00);
        Teclado teclado = new Teclado("usb", "logitech");
        Raton raton = new Raton("USB-2", "logitech");

        ComputadoraLab computadora = new ComputadoraLab("MSI", monitor, raton, teclado);
        OrdenComputadora orden1 = new OrdenComputadora();
        orden1.agregar(computadora);
        System.out.println("fin");

    }
}
