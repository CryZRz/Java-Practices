package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //inicia la transaccion
        
        //Paso 1.-Inicar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       
        //Paso 2 .- ejecutamos un SQL de tipo select
        Persona persona = em.find(Persona.class, 4);
        
        //Para una sola transaccion :)
        //Paso 3.- termina la transaccion 1
        //em.remove(persona);
        
        //Objeto en esta detached
        //log.debug("Objeto encontrado" + persona);
        
        tx.commit();
        
        //para dos transacciones c:
        //Paso 4.- iniciamos transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 5.- Ejecutar el SQL que es un delete
        em.remove(em.merge(persona));
        
        //Paso 6.- termina transaccion 2
        tx2.commit();
        
        //Objeto en estado detached ya eliminado
        log.debug("Objeto eliminado" + persona);
        
        em.close();
    }
}
