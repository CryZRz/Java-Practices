package learning.metodos;

public class PruebAritmetica {
    public static void main(String[] args) {

        //variables locales
        int a = 10; //varibles guardadas en memoria stack
        int b = 5;

        miMetod();

        // Aritmetica aritmetica1 = new Aritmetica();

        // aritmetica1.a = 3;
        // aritmetica1.b = 2;
        // aritmetica1.sum();

        // var resultado = aritmetica1.sumar();
        // System.out.println(resultado);
        
        // resultado = aritmetica1.sumarConArgumentos(10, 15);
        // System.out.println(resultado);

        // var resultadoThis = aritmetica1.sumarConArgumentos(20, 15);
        // System.out.println(resultadoThis);

        Aritmetica aritmetica1 = new Aritmetica(); //la variable aritmetica esta en la memoria stack y apunta al objeto guardado en la memoria heap 
        System.out.println(aritmetica1.a);
        System.out.println(aritmetica1.b);

        Aritmetica aritmetica2 = new Aritmetica(10, 20);
        System.out.println(aritmetica2.a);
        System.out.println(aritmetica2.b);

        aritmetica1 = null;
        System.gc(); //el garbage collector borra los elementos en memoria heap que ya no se estan siendo usados en este caso aritmetica1

    }

    public static void miMetod(){
        //la variable a esta fuera del alcance donde fue definida
        //a = 10;
        System.out.println("otro metodo");
    }

}
