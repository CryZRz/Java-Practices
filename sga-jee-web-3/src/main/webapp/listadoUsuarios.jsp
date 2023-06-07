<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>
        <c:forEach items="${usuarios}" var="usuario">
            <li>${usuario.username} ${usuario.password}</li>
        </c:forEach>
    </body>
</html>
