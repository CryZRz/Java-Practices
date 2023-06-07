package mx.com.gm.sga.servicio;

import java.util.List;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDao;
import mx.com.gm.sga.domain.Usuario;

public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{

    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDao.findAllUsuario();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDao.findUsuarioByUsername(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updatedUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
