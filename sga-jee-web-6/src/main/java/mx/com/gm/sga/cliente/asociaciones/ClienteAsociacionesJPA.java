package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger(); 
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();

        //cerrar la conexion
        em.close();
        
        //imprimir todos los objetps de tipo persona
        for (Persona persona : personas) {
            log.debug("persona: " + persona);
            
            //recuperamos los objetos de cada persona
            for (Usuario usuario : persona.getUsuarioList()) {
                log.debug("usuario: " + usuario);
            }
        }
    }
    
}
