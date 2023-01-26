<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores del java bean</title>
    </head>
    <body>
        <h1>JSP que lee los valores del java bean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br>
        Valor base:
        <jsp:getProperty name="rectangulo" property="base" />
        <br>
        Valor de altura
        <jsp:getProperty name="rectangulo" property="altura" />
        <br>
        Valor del area:
        <jsp:getProperty name="rectangulo" property="area" />
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
