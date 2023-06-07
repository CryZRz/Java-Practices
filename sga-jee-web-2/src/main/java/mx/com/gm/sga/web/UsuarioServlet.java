package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioService;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet{

    @Inject
    private UsuarioService usuarioService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Usuario> usuarios =  usuarioService.listarUsuario();
        System.out.println("usuarios:" + usuarios);
        req.setAttribute("usuarios", usuarios);
        req.getRequestDispatcher("listadoUsuarios.jsp").forward(req, resp);
    }
    
}
