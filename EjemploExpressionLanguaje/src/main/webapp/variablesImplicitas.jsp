<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL y Variables implicitas</title>
    </head>
    <body>
        <h1>EL y Variables implicitas</h1>
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["User-Agent"]}</li>
            <li>Id Session: ${cookie.JSESSIONID.value}</li>
            <li>Web server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor parametro: ${param.usuario}</li>
        </ul>
        <br>
        <a href="index.jsp">Ir al inicio</a>
    </body>
</html>
