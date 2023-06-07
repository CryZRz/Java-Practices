<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <s:property value="formTitulo" /> </title>
    </head>
    <body>
        <h1> <s:property value="formTitulo" /> </h1>
        <s:form>
            <s:textfield key="form.usuario" name="usuario" />
            <s:password key="form.password" name="password" />
            <s:submit key="form.bton" name="submit" />
        </s:form>
        <div>
            <s:text name="form.valores" />:
            <br/>
            <s:property value="formUsuario"/>: <s:property value="usuario"/>
            <br/>
            <s:property value="formPassword" />: <s:property value="password"/>
        </div>
    </body>
</html>
