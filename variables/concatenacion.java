package learning.variables;

public class concatenacion {
    public static void main(String[] args) {
        var usuario = "Christian";
        var titulo = "Ingeniero";
        var union = titulo + " " + usuario;

        System.out.println(union);

        var y = 3;
        var j = 4;

        System.out.println(y+j);
        System.out.println(y + j + union);
        System.out.println(union + y + j);
        System.out.println(union + (y + j));
    }
}
