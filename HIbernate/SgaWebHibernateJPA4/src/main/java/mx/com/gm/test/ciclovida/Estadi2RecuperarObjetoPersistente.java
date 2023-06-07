package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estadi2RecuperarObjetoPersistente {
 public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos la variable
        Contacto contacto = null;
        
        //recuperar objeto de la base de datos
        contacto = em.find(Contacto.class, 3);
        
        //estado de detached
        System.out.println("contacto: " + contacto);
    }
}
