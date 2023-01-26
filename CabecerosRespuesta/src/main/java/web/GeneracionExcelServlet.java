package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {
       protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
           
           //establecer headers
           res.setContentType("application/vnd.ms-excel");
           res.setHeader("Content-Disposition","attachment;filename=excelEjemplo.xls");
           //para un uso mas profesional de excel poi.apache.org
           
           //indicar al navegador que no guarde cache
           res.setHeader("Pragma", "no-cache");
           res.setHeader("Cache", "no-store");
           res.setDateHeader("Expire", -1);
           
           //desplegar informacion al cliente
           PrintWriter out = res.getWriter();
           out.println("\tValores");
           out.println("\t1");
           out.println("\t2");
           out.println("Total\t=SUMA(b2:b3)");
           out.close();
       }
}
