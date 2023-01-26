<%@page errorPage="/WEB-INF/manejorErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo = "reporte.xls";
      response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte excel JSP</title>
    </head>
    <body>
        <h1>Reporte excel JSP</h1>
        <br>
        <table border="1">
            <tr>
                <th>
                    Curso
                </th>
                <th>
                    Descripcion
                </th>
                <th>
                    fecha
                </th>
            </tr>
            <tr>
                <td>1.- Fundamentos de java</td>
                <td>Aprenderemos la sintaxis basica de java</td>
                <td><%= Conversiones.format("hola") %></td>
            </tr>
            <tr>
                <td>2.- progrmacion con java</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
