package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionesServlet")
public class SessionServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset-UTF-8");
        
        HttpSession sesion = req.getSession();
        String titulo = null;
        
        //pedir el atributo contadorVisitas a la session
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //si es nulo es la primera vez que accedemos a la aplicacion
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //mandamos la respuesta al cliente
        PrintWriter out = res.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("Numero de accesos al recurso " + contadorVisitas);
        out.print("<br>");
        out.print("ID de la session" + sesion.getId());
        out.close();
        
    }

}
