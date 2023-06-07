package mx.com.gm.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletRedireccionar")
public class SerlvetRedireccionar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/agregarAlumno.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}
