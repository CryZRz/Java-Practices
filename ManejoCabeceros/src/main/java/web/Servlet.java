package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html,charset-UTF-8");
        PrintWriter out = res.getWriter();
        String metodoHttp = req.getMethod();
        String uri = req.getRequestURI();
        Enumeration cabeceros = req.getHeaderNames();
        out.print("<h1> Metodo HTTP: </h1>");
        out.print(metodoHttp);
        out.print("<h1> Uri solicitada: </h1>");
        out.print(uri);
        out.print("<br>");
        out.print("<br>");
        while (cabeceros.hasMoreElements()) {
            String nombreCabecero = (String)cabeceros.nextElement();
            out.print("<br>cabecero Nombre </br>");
            out.print(req.getHeader(nombreCabecero));
            out.print("<br>");
        }
        out.close();
    }
    
}
