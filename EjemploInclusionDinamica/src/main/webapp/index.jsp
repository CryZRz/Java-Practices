<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusion dinamica</title>
    </head>
    <body>
        <h1>Ejemplo inclusion dinamica</h1>
        <br>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="purple"/>
        </jsp:include>
    </body>
</html>
