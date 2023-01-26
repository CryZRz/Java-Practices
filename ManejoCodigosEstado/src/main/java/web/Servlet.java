package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        //Simular valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";
        
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        
        PrintWriter out = res.getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("datos correctos");
            out.print("<br>");
            out.print(usuario);
            out.print(password);
            out.print("</h1>");
        }else{
            res.sendError(res.SC_UNAUTHORIZED, "las credenciales son incorrectas");
        }
        out.close();
        
    }
}
