package test;

import java.util.List;

import datos.UsuarioDAO;
import domain.Usuario;

public class TestManejoUsuario {
    public static void main(String[] args) {
        UsuarioDAO testUsuarioDao = new UsuarioDAO();

        //insert
        //var usuario = new Usuario("Evelin", "contraseña hyper secreta");
        //testUsuarioDao.insertar(usuario);

        //update
        //var usuarioUpdate = new Usuario(3, "Alicia", "12345678");
        //testUsuarioDao.actualizar(usuarioUpdate);

        //delete
        var usuarioDelete = new Usuario(4);
        testUsuarioDao.delete(usuarioDelete);

        List<Usuario> usuarios = testUsuarioDao.seleccionar();
        for (Usuario usuarioSelect : usuarios) {
            System.out.println(usuarioSelect);
        }
    }
     

}
