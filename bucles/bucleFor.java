package learning.bucles;

public class bucleFor {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0) {
               System.out.println(i + " es numero par");
               break; 
            }
        }

        for (int i = 1; i < 5; i++) {
            if (i % 2 != 0) {
               continue; 
            }
            System.out.println(i);
        }

    }
}
