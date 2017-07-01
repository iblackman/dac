<%-- 
    Document   : T_Login
    Created on : 20/06/2017, 23:12:03
    Author     : caio
--%>

<link rel="stylesheet" href="./CSS/Menu_estilo.css" type="text/css" /> 

<div class="menu">

    <div id="itens_menu">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="listarEventos" >Lista de Eventos</a></li>
            <%if (request.getSession().getAttribute("logou") == null){%>
            <li><a href="login.jsp">Login</a></li>
            <%}%>
            <%if (request.getSession().getAttribute("logou") != null){%>
            <li><a href="ferramentasadm.jsp">Ferramentas Administrativas</a></li>
            <%}%>
            
        </ul>
    </div>
    
</div>
