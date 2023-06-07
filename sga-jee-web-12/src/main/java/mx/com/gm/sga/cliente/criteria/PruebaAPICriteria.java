package mx.com.gm.sga.cliente.criteria;

import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaAPICriteria {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el API de criteria
        //1.- consulta todas las personas
        
        //paso1 .- el objeto entitymanager crea una instancia criteria builder
        cb = em.getCriteriaBuilder();
        
        //paso2 .- se crea un objeto criteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //paso3 .- creamos el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //paso4.- seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //paso5 creamos el tipo de query
        query = em.createQuery(criteriaQuery);
        
        //paso6 .- ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);
        
        //2a. consulta de la persona con id igual 1
        log.debug("consulta de la persona con id igual 1");
        
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug("persona: " + persona);
    }
    
    private static void mostrarPersonas(List<Persona> personas){
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
    
}
