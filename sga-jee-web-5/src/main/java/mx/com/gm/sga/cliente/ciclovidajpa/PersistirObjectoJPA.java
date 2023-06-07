package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjectoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //inicia la transaccion
        
        //Paso 1.-Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona = new Persona("Pedro", "Luna", "pluna@mail.com", "45788912");
        
        //Paso 2.- inicia transaccion
        tx.begin();
        
        //paso 3.- Ejecuta el sql
        em.persist(persona);
        
        log.debug("Objeto persistido - en estado commit" + persona);
        
        //paso 4.- hacer commit/rollback
        tx.commit();
        
        //Objeto en estado detached
        log.debug("Objeto persistido - en estado detached" + persona);
        
        em.close();
    }
    
}
