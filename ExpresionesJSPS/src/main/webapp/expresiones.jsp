<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con expresiones</title>
    </head>
    <body>
        <h1>js con expresiones</h1>
        Concatenacion <%= "saludos" + " " + "JSP" %>
        <br>
        Operacion matematica <%= 2*3/2  %>
        <br>
        Session id: <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
