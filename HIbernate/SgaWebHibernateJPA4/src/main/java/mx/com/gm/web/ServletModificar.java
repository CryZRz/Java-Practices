package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.servicio.ServicioAlumno;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {
    
    ServicioAlumno servicioAlumno = new ServicioAlumno();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlumnoS = req.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);

        Alumno alumno = new Alumno(idAlumno);
        alumno = servicioAlumno.encontrarAlumno(alumno);

        //req.setAttribute("alumno", alumno);
        HttpSession session = req.getSession();
        session.setAttribute("alumno", alumno);

        req.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String modificar = req.getParameter("modificar");

        if (modificar != null) {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String calle = req.getParameter("calle");
            String noCalle = req.getParameter("noCalle");
            String pais = req.getParameter("pais");
            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");

            HttpSession session = req.getSession();
            Alumno alumno = (Alumno) session.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            session.removeAttribute("alumno");

            req.getRequestDispatcher("/index.jps").forward(req, resp);
        }else{
            //caso eliminar
            String idAlumnoS = req.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            
            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);
            
            req.getRequestDispatcher("/index.jps").forward(req, resp);
        }

    }

}
