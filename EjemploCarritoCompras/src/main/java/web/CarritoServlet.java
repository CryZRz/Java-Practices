package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset-UTF-8");
        
        //recuperamos el objeto httpSession
        HttpSession session = req.getSession();
        
        //recuperar la lista de articulos previamente si es que existe
        List<String>articulos = (List<String>) session.getAttribute("articulos");
        
         //procesamos el nuevo articulo
        String articuloNuevo = req.getParameter("articulo");
        
        //verificamos si la lista de articulos existe
        if (articulos == null) {
            //inicializando la lista de articulos
            articulos = new ArrayList();
            session.setAttribute("articulos", articulos);
        }
        
        //revisamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        
        try ( //imprimimos la lista de articulos
                PrintWriter out = res.getWriter()) {
            out.print("Lista de articulos");
            out.print("<br>");
            
            //iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<span>" + articulo + "</span>");
                out.print("<br>");
            }
            
            //agregamos un link prara regresar al inicio
            out.print("<a href='/EjemploCarritoCompras'>Ir al inicio</a>");
        }
        
    }
    
}
