public class VentasTest {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Agua", 25.00);
        Producto producto2 = new Producto("camisa", 50.00);

        Orden orden1 = new Orden();
        orden1.agregarProducto(producto2);
        orden1.mostrarOrden();

    }
}
