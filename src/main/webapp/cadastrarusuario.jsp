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


        <div id="conteudo">
            <link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


            <form method="post" id="login" action="CadastroUsuario">
                Nome: <br><input type="text" id="nome" name="nome"/><br>
                Email:<br> <input type="text" id="email" name="email"/><br>
                Login:<br> <input type="text" id="usuario" name="usuario"/><br>
                Senha:<br> <input type="password" id="senha" name="senha"/><br><br>
                <input type="submit" value="Cadastrar" /> <input type="button" onclick ="history.back()" value="Voltar" /> 
            </form>
        </div>
        <%Boolean cadastrou = (Boolean) request.getAttribute("cadastrou");
                if (cadastrou != null) {%>
        Usuario cadastrado com sucesso.
        <%}%>

        <%@include file="footer.jsp" %>
    </body>
</html>
