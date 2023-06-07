package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        //Paso 1.- crear un objeto 
        //objeto en estado transitivo
        Persona persona = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "45895632");
        
        //creamos un objeto usuario (tiene dependencia con el objeto persona)
        Usuario usuario = new Usuario("hhernandez", "123", persona);
        
        //Paso3.- persistimos el objeto usuario unicamente
        em.persist(usuario);
        
        //paso 4.- hacemos comit
        tx.commit();
        
        //objeto en estado de detached
        log.debug("objeto persistido persona" + persona);        
        log.debug("objeto persistido usuario" + usuario);

        em.close();
    }
    
}
