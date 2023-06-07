package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjectoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //inicia la transaccion
        
        //Paso 1.-Inicar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       
        //Paso 2.- ejecutar sql de tipo select
        Persona persona = em.find(Persona.class, 3);
        
        //Paso3 .- termina la transaccion
        tx.commit();
        
        //Objecto en estado de detached
        log.debug("Objeto recuperado" + persona);
        
        em.close();
    }
}
