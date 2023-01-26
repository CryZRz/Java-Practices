<%-- 
    Document   : index
    Created on : 9 ene 2023, 22:47:52
    Author     : christian
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola mundo jsps</title>
    </head>
    <body>
        <h1>Hola mundo jsp</h1>
        <ul>
            <li> <% out.print("Hola mundo con scriplets"); %> </li>
            <li> ${"Hola mundo con expression leanguaje (EL)"}  </li>
            <li> <%= "Hola mundo con expressiones"  %> </li>
            <li> <c:out value="Hola mundo con JSTL" /> </li>
        </ul>
    </body>
</html>
