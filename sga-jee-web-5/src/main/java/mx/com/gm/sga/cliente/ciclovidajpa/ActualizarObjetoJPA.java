package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //inicia la transaccion
        
        //Paso 1.-Inicar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       
        //Paso 2.- Ejecutar SQL de tipo select
        //El id proporcionado debe existir en la base de datos
        Persona persona = em.find(Persona.class, 1);
        
        //Paso 3.- termina la transaccion 1
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto recuperado:" + persona);
        
        //Paso 4.- setValue (nuevo valor)
        persona.setApellido("Hernandez");
        
        //Paso 5.-Iniciar transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx.begin();
        
        //Paso 6.- modificar el objeto
        em.merge(persona);
        
        //Paso 7.-Termina transaccion 2
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto recuperado: " + persona);
        
        em.close();
    }
}
