<%-- 
    Document   : T_Login
    Created on : 20/06/2017, 23:12:03
    Author     : caio
--%>

<link rel="stylesheet" href="./CSS/Menu_estilo.css" type="text/css" /> 
<link rel="stylesheet" href="./CSS/estilo.css" type="text/css" /> 
<div class="menu">

    <div id="itens_menu">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="listarEventos" >Lista de Eventos</a></li>
            <%if (request.getSession().getAttribute("logou") == null){%>
            <li><a href="login.jsp">Login</a></li>
            <%}%>
            <%if ((request.getSession().getAttribute("logou") != null) && (request.getSession().getAttribute("permissao") != null) && ((Integer)request.getSession().getAttribute("permissao") == 1)){%>
            <li><a href="ferramentasadm.jsp">Ferramentas Administrativas</a></li>
            <%}%>
            <%if (request.getSession().getAttribute("logou") != null && (request.getSession().getAttribute("permissao") != null) && (((Integer)request.getSession().getAttribute("permissao") == 3)||((Integer)request.getSession().getAttribute("permissao") == 2))){%>
            <li><a href="ferramentasadm.jsp">Inscrever-se em evento</a></li>
            <%}%>
            <%if (request.getSession().getAttribute("logou") != null && (request.getSession().getAttribute("permissao") != null) && ((Integer)request.getSession().getAttribute("permissao") == 2)){%>
            <li><a href="criarevento.jsp">Gerenciar Evento</a></li>
            <%}%>
            <% if(session.getAttribute("user") != null) {%>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            <%}%>
        </ul>
    </div>
    
</div>
