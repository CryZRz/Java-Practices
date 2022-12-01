public class TestArreglos {
    public static void main(String[] args) {
        int edades[] = new int[3];
        System.out.println(edades);

        edades[0] = 12;
        edades[1] = 30;
        edades[2] = 35;
        
        for (int i = 0; i < edades.length; i++) {
            System.out.println(edades[i]);
        }

    }
}
