package learning.tiposDeDatos;

public class TipoChar {
    public static void main(String[] args) {

        //tipo char 16 bits
        char miCharacter = 'c';
        System.out.println(miCharacter);
    
        char varChar = '\u0021';
        System.out.println(varChar);

        char varCharDecimal = 33;//no se puede usar var por que no infiera correctamnete el tipo
        System.out.println(varCharDecimal);

        var varCharSimbolo = '!';
        System.out.println(varCharSimbolo);

        int varCharEnteroSimbolo = 'a';//devuelve el numero de caracter del char
        System.out.println(varCharEnteroSimbolo);
    }
}
