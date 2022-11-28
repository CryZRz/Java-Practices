package learning.metodos;

public class Aritmetica {
    //atributos de la clase
    int a;
    int b;

    //constructor
    public Aritmetica(){
        System.out.println("ejecutando constructor");
    }

    //sobrecarga de constructor
    public Aritmetica(int a, int b){
        this.a = a;
        this.b = b;
        System.out.println("ejecutando construcctor con argumentos");
    }

    //metodo
    public void sum(){
        int resultado = a + b;
        System.out.println(resultado);
    }

    public int sumar(){

        return a + b;
    }

    public int sumarConArgumentos(int arg1, int arg2){
        a = arg1;
        b = arg2;

        //return a + b;
        return sumar();
    }

    public int SumaThis(int a, int b){
        this.a = a;
        this.b = b;

        //return a + b;
        return this.sumar();
    }

}
