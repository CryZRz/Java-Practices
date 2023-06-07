package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query query = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //Paso1.- Consultar todos los objetos de tipo persona
        log.debug("Consulta todas las personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
    
        //consulta de la persona con id = 1
        log.debug("Consulta de la persona con id 1");
        jpql = "select p from Persona p where p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);
        
        //consulta de la persona por nombre
        jpql = "select p from Persona p where p.nombre = 'Karla'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //consulta de datos individuales se crea un arreglo que es una tupla de tipo object de 3 columnas
        log.debug("consulta de datos individuales se crea un arreglo que es una tupla de tipo object de 3 columnas");
        jpql = "select p.nombre as nombre, p.apellido as apellido, p.email as email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        
        while (iter.hasNext()) {            
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("nombre: " + nombre + "apellido: " + apellido + "email: " + email);
        }
        
        //5. obtiene el objeto persona y el id, se crea un array de tipo object con dos columnas
        log.debug("obtiene el objeto persona y el id, se crea un array de tipo object con dos columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        
        while (iter.hasNext()) {            
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            
            //log.debug("objeto persona: " + persona + "id persona: " + idPersona);
        }
        
        //6. consultar todas las personas
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //7 regresa el valor minimo y maximo del id persona
        log.debug("regresa el valor minimo y maximo del id persona");
        jpql = "select min(p.idPersona) as minId, max(p.idPersona) as maxId, count(p.idPersona) as contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        
        while (iter.hasNext()) {            
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];

            //log.debug("idMin: " + idMin + "idMax: " + idMax + "contador: " + count);
        }
        
        //8. cuenta los nombres de las personas que son distintos
        log.debug("cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("numero de personas con nombres disitintos: " + contador);
        
        //9.concatena y convierte a mayusculas nombre y apellido
        log.debug("concatena y convierte a mayusculas nombre y apellido");
        jpql = "select concat(p.nombre,' ',p.apellido) as nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        
        for (String nombre : nombres) {
            //log.debug(nombre);
        }
        
        //10. obtiene el objeto persona con id igual al parametro proporcionado
        log.debug("obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 1;
        jpql = "select p from Persona p where p.idPersona = :id";
        query = em.createQuery(jpql);
        query.setParameter("id", idPersona);
        persona = (Persona) query.getSingleResult();
        //log.debug("persona: " + persona);
        
        //11. obtiene las personas que contengan una letra a en el nombre sin importar si es A o a
        log.debug("obtiene las personas que contengan una letra a en el nombre sin importar si es A o a");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%k%";//es el caracter que usamos para la sentencia like
        query = em.createQuery(jpql);
        query.setParameter("parametro", parametro);
        personas = query.getResultList();
        //mostrarPersonas(personas);
        
        //12 uso de beetwen
        jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
    
        //13. uso del ordenamiento
        jpql = "select p from Persona p where p.idPersona > 3 order by p.nombre, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
    }
    
    private static void mostrarPersonas(List<Persona> personas){
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
    
}
