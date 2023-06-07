package test;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.domain.Persona;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for (Persona persona : personas) {
            System.out.println("persona" + persona);
        }
    }
}
