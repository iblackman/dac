<%-- 
    Document   : T_Login
    Created on : 20/06/2017, 23:12:03
    Author     : caio
--%>
<jsp:include page="menu.jsp"/>
<div id="conteudo">
    <link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
    <form method="post" id="login" action="Login">
        Login:<br> <input type="text" id="usuario" name="usuario"/><br>
        Senha: <br><input type="password" id="senha" name="senha"/><br>
        <input type="submit" value="Entrar" /> <br>
    </form>         
    <a href="cadastrarusuario.jsp">Cadastrar Usuario</a>
    <%Boolean incorrect = (Boolean) request.getAttribute("incorrect");
            if (incorrect != null) {%>
    Usuario ou senha incorretos.
    <%}%>
</div>
<%@include file="footer.jsp" %>

