package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Leer los parametro del formulario html
        String usuario = request.getParameter("usuario");
         String password = request.getParameter("password");
         
         System.out.println("usuario: " + usuario);
         System.out.println("password" + password);
         
         PrintWriter out  = response.getWriter();
         out.println("<h3>EL valor de usuario es ".concat(usuario).concat("</h3>"));
         out.println("<h3>EL valor de la contraseña es ".concat(password).concat("</h3>"));
         out.close();
    }
    
}
