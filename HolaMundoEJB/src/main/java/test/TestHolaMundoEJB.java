package test;

import beans.HolaMundoEJBRemote;
import javax.naming.*;

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        
        try {
            Context jndi = new InitialContext();
            HolaMundoEJBRemote holaMundoEjb = (HolaMundoEJBRemote)jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEjb.sumar(10, 25);
            System.out.println(resultado);
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
        
    }
}
