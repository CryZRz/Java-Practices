<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <!--- Manupulacion de variables-->
        
        <!-- definimis la variable-->
        <c:set var="nombre" value="Ernesto" />
        
        <!-- desplegamos el valor de la variable -->
        Variable nombre <c:out value="${nombre}" />
        <br>
        <br>
        Variable con codigo html
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br>
        <br>
        <!-- Codigo condicionado, el uso de if -->
        <c:set var="bandera" value="true" />
        <c:if test="${!bandera}">
            La bandera es verdadera
        </c:if>
         <br>
         <!-- Codigo condicionado, el uso de switch -->
         <c:if test="${param.opcion != null}">
             <c:choose>
                 <c:when test="${param.opcion == 1}" >
                     <br>
                     Opcion 1 seleccionada
                 </c:when>
                 <c:when test="${param.opcion == 2}" >
                     <br>
                     Opcion 2 seleccionada
                 </c:when>
                 <c:otherwise>
                     <br>
                     Opcion proporcionada desconocida: ${param.opcion}
                 </c:otherwise>
             </c:choose>
         </c:if>
         <!-- iteracion de un arreglo -->
         <% 
                String nombres[] = {"claudia", "pedro", "juan"};
                request.setAttribute("nombres", nombres);
         %>
         <br>
         Lista de nombres:
         <br>
         <ul>
             <c:forEach var="nombre" items="${nombres}" >
                 <li>Nombre: ${nombre}</li>
             </c:forEach>
         </ul>
         <br>
         <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
