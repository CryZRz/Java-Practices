<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC2</h1>
        <br>
        <div style="color: red">${mensaje}</div>
        <br>
        <br>
            <a href="${pageContext.request.contextPath}/ServletControlador">Link al server controlador sin parametros</a>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
                Link al server controlador para agregar variables
            </a>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
                Link al server controlador para listar variables
            </a>
    </body>
</html>
