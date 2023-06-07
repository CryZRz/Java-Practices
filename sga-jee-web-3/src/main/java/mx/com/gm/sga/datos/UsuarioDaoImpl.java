package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.*;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext(unitName = "PersonaPu")
    EntityManager em;
    
    
    @Override
    public List<Usuario> findAllUsuario() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        Query query = em.createQuery("from Usuario u WHERE u.username =: username");
        query.setParameter("username", usuario.getUsername());
        
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updatedUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
    
}
