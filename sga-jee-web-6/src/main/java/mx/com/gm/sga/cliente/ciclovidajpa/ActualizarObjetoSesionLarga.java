package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //inicia la transaccion
        
        //Paso 1.-Inicar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       
        //Paso 2.- ejecutamos el SQL de tipo select
        Persona persona = em.find(Persona.class, 1);
        
        log.debug("Objeto encontrado: " + persona);
        
        //Paso 3.-setValue(nuevoValor)
        persona.setEmail("jhernandez@mail.com");
        
        persona.setTelefono("55896321");
        
        //Paso 4.- termina la transaccion
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto modificado: " + persona);
        
        em.close();
    }
}
