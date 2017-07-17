<%-- 
    Document   : FerramentasAdm
    Created on : 20/06/2017, 21:45:24
    Author     : caio
--%>

<link rel="stylesheet" href="./CSS/estilo.css" type="text/css" /> 

<%@include file="menu.jsp" %>

<div id="submenu">

    <% if (request.getSession().getAttribute("logou") != null  && ((Integer)request.getSession().getAttribute("permissao") <= 3)) { %>
    <table><thead><tr><th>Participação</th></tr></thead>
        <tdoby>
            <tr><td><a href = "criareventos.jsp">Criar Eventos</a></td></tr>

            <tr><td><a href = "listEventInsc">Cancelar inscrição em Eventos</a></td></tr>
            <tr><td><a href = "inscEmEventos">Inscrição em Eventos</a></td></tr>
        </tdoby></table>
        <% }%>

    <% if (request.getSession().getAttribute("logou") != null && ((Integer)request.getSession().getAttribute("permissao") <= 2)) { %>
    <table>
        <thead><tr><th>Controle</th></tr></thead>
        <tdoby>
            <tr><td><a href = "listEveDoHost">Controle de Inscritos</a></td></tr>
        </tdoby></table>

    <% }%>

    <% if (request.getSession().getAttribute("logou") != null  && ((Integer)request.getSession().getAttribute("permissao") <= 1)) { %> 

    <table><thead><tr><th>Aprovação</th></tr></thead>
        <tdoby>
            <tr><td><a href = "ListarEventosWaitStatus">Aprovação de Eventos</a></td></tr>
            <tr><td><a href = "admRoom">Salas</a></td></tr>
            <tr><td><a href = "admResource">Recursos</a></td></tr>
        </tdoby></table>
        <% }%>






</div>


<%@include file="footer.jsp" %>
