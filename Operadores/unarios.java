package learning.Operadores;

public class unarios {
    public static void main(String[] args) {
        var a = 3;
        var b = -a;
        System.out.println(a);
        System.out.println(b);

        var c = true;
        var d = !c;
        System.out.println(c);
        System.out.println(d);

        //incremento
        //preincremento (simbolo antes de la variable)
        var e = 3;
        var f = ++e;//primero se incrementa la variable y despues se usa su valor
        System.out.println(e);
        System.out.println(f);
        
        //post incremento (simbolo despues de la variable)
        var g = 5;
        var h = g++;//priemro se utiliza el valor de la variable y despues se incrementa
        System.out.println(g);
        System.out.println(h);

        //decremento
        //predecremento
        var i = 2;
        var j = --i;
        System.out.println(i);
        System.out.println(j);

        //postdecremento
        var k = 2;
        var l = k--;
        System.out.println(k);
        System.out.println(l);
    }
}
