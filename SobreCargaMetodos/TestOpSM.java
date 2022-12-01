public class TestOpSM {
    public static void main(String[] args) {
        var res = OperacionesSM.sumar(15, 25);
        System.out.println("int" + res);
        var res2 = OperacionesSM.sumar(25.5, 15.6);
        System.out.println("double: " + res2);
        var res3 = OperacionesSM.sumar(5, 5L);
        System.out.println(res3);
    }
}
