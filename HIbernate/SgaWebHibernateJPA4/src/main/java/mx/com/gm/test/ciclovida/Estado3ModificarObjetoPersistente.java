package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
 public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos la variable
        Contacto contacto = null;
        
        //recuperar objeto de la base de datos
        //estado de transitivo
        contacto = em.find(Contacto.class, 3);
        
        //moficamos el obejto
        contacto.setEmail("clara@mail.com");
        
        em.getTransaction().begin();
        
        //2.-persistente
        //em.persist(contacto);
        em.merge(contacto);
        
        em.getTransaction().commit();
        
        
        //3.- estado de detached
        System.out.println("contacto: " + contacto);
    }
}
