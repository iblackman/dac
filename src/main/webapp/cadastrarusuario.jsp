<%-- 
    Document   : cadastrarusuario
    Created on : 26/06/2017, 17:39:26
    Author     : Thadeu Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuario</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form method="post" id="login" action="CadastroUsuario">
            Nome: <input type="text" id="nome" name="nome"/><br>
            Email: <input type="text" id="email" name="email"/><br>
            Login: <input type="text" id="usuario" name="usuario"/><br>
            Senha: <input type="password" id="senha" name="senha"/><br>
            <input type="submit" value="Cadastrar" /> <br>
        </form>     
        <%Boolean cadastrou = (Boolean)request.getAttribute("cadastrou"); 
        if (cadastrou!=null){%>
        Usuario cadastrado com sucesso.
        <%}%>
        <%@include file="footer.jsp" %>
    </body>
</html>
