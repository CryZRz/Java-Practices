package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html, charset=UTF-8");
        PrintWriter out = res.getWriter();
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        String tecnologias[] = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String musicas[] = req.getParameterValues("musica");
        String comentarios = req.getParameter("comentarios");
        
        out.println("<h1>Datos del usuario: </h1>");
        out.println("<p>"+ usuario+"</p>");
        out.println("<p>"+ password+"</p>");
        
        for (String tecnologia : tecnologias) {
            out.println("<p>"+ tecnologia+"</p>");
        }
        out.println("<p>"+ genero+"</p>");
        out.println("<p>"+ ocupacion+"</p>");
        
        if (musicas != null) {
             for (String musica : musicas) {
                out.println("<p>"+ musica+"</p>");
            }
        }else{
            out.println("<p>No se selecciono musica de interes</p>");
        }
         
         if (comentarios != null) {
            out.println("<span>"+ comentarios+"</span>");
        }else{
             out.println("<span>No hay comentarios</span>");
         }
        
    }
    
}
