package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEJBIml implements HolaMundoEJBRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo suma en el servidor");
        return a + b;
    }
    
}
