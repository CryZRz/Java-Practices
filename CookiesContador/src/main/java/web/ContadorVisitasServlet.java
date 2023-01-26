package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        //declaramos la variable contador
        int contador = 0;
        
        //revisar si existe la cookie contadorVisitas
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                  if (cookie.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        //incrementar el contador en 1
        contador++;
        Cookie cookie = new Cookie("contadorVisitas", Integer.toString(contador));
        //la cookie se almacenara en el cliente por una hora es decir 3600s
        cookie.setMaxAge(3600);
        res.addCookie(cookie);
        
        //mandamos el mensaje al navegador
        res.setContentType("text/html;charset-UTF-8");
        PrintWriter out = res.getWriter();
        out.print("Contador de visiras de cada cliente " + contador);
        out.close();
    }
    
}
