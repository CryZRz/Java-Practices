package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Persona> personas = personaService.listarPersona();
        System.out.println(personas);
        req.setAttribute("personas", personas);
        req.getRequestDispatcher("/listadoPersonas.jsp").forward(req, res);
    }
    
}
