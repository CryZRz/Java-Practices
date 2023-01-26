package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        //Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        
        //obtener el arreglo de cookies
        Cookie[] cookies = req.getCookies();
        
        //buscamos si ya existe una cookie creada con anterioridad
        //llamada visitante recurrente
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                  if (cookie.getName().equals("visitanterecurrente") && cookie.getValue().equals("si")) {
                      //si ya existe la cookies es un usuario recurrente
                      nuevoUsuario = false;
                      break;
                }
            }
        }
        
        String mensaje = null;
        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanterecurrente", "si");
            res.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        res.setContentType("text/html:charset-UTF-8");
        PrintWriter out = res.getWriter();
        out.print(mensaje);
        out.close();
    }
    
}
