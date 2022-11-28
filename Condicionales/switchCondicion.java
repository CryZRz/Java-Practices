package learning.Condicionales;

public class switchCondicion {
    public static void main(String[] args) {
        var numero = 2;
        var numeroTexto = "Valor desconocido";
        switch (numero) {
            case 1:
                numeroTexto = "uno";
                break;
            case 2:
                numeroTexto = "dos";
                break;
            case 3:
                numeroTexto = "tres";
                break;
            case 4: 
                numeroTexto = "cuatro";
            default:
                numeroTexto = "Valor desconocido";
                break;
        }

        System.out.println(numeroTexto);
    }
}
