<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALcance variables</title>
    </head>
    <body>
        <h1>ALcance variables</h1>
        <br>
        Variable request:
        Base: ${rectanguloRequest.base}
        Altura ${rectanguloRequest.altura}
        Area ${rectanguloRequest.area}
        <br>
        <br>
        Variable session:
        Base: ${rectanguloSession.base}
        Altura ${rectanguloSession.altura}
        Area ${rectanguloSession.area}
        <br>
        <br>
        Variable aplicacion:
        Base: ${rectanguloAplicacion.base}
        Altura ${rectanguloAplicacion.altura}
        Area ${rectanguloAplicacion.area}
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/index.jsp">Ir al inicio</a>
    </body>
</html>
