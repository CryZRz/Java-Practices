package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        //1.- Procesamos parametros
        String accion = req.getParameter("accion");
        
        
        //2.-Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recAplicacion = new Rectangulo(5, 6);
        
        //3.-Agregamos el javaBean a algun alcance
        
        //revisamos la  accion proporcionada
        if ("agregaVariables".equals(accion)) {
            
            //alacnce de request
            req.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance de session
            HttpSession session = req.getSession();
            session.setAttribute("rectanguloSession", recSession);
            
            //Alcance de aplicacion
            ServletContext aplication = this.getServletContext();
            aplication.setAttribute("rectanguloAplicacion", recAplicacion);
            
            //Agregamos un mensaje
            req.setAttribute("mensaje", "las variables fueron agregadas");
            
            //4.- redireccionamos al jsp de index
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
        else if ("listarVariables".equals(accion)) {
            //4.- Redireccionamos al jsp que despliega las variables
            req.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(req, res);
            
        }
        else{
            //4.-redireccionamos pero a la pagina de inicio
            req.setAttribute("mensaje", "accion no proporcionada o desconsida");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        
            //esta accion no agregaria la informacion al JSP, ya que no propaga los objetos request y response
            //res.sendRedirect("index.jsp");
        }
        
       
    }
    
}
