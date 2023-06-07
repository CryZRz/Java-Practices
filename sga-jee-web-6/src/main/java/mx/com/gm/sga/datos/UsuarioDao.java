package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

public interface UsuarioDao  {
    public List<Usuario> findAllUsuario();
    
    public Usuario findUsuarioById(Usuario usuario);
    
    public Usuario findUsuarioByUsername(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);
    
    public void updatedUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
}
