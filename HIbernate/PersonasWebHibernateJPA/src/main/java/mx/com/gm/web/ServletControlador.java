package mx.com.gm.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        
        ServicioPersonas servicioPersonas = new ServicioPersonas();
        List<Persona> personas = servicioPersonas.listarPersonas();
        
        req.setAttribute("personas", personas);
        
        try {
            req.getRequestDispatcher("/WEB-INF/listado.jsp").forward(req, resp);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
