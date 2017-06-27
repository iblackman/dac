<%-- 
    Document   : T_Login
    Created on : 20/06/2017, 23:12:03
    Author     : caio
--%>
        <jsp:include page="menu.jsp"/>
        <form method="post" id="login" action="Login">
           Login: <input type="text" id="usuario" name="usuario"/><br>
           Senha: <input type="password" id="senha" name="senha"/><br>
           <input type="submit" value="Entrar" /> <br>
        </form>         
        <a href="cadastrarusuario.jsp">Cadastrar Usuario</a>
        <%Boolean incorrect = (Boolean)request.getAttribute("incorrect"); 
        if (incorrect!=null){%>
        Usuario ou senha incorretos.
        <%}%>
        <%@include file="footer.jsp" %>

