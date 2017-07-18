<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%
    String dateIn = request.getParameter("dataIn").replace("T", " ");
    String dateFim = request.getParameter("dataFim").replace("T", " ");
    
%>
<div id="index"> 
    <h1>CRIAR EVENTOS</h1>

    <link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


    Inicio do Evento: <br>
    <%= dateIn%><br>

    Fim do Evento:<br>
    <%= dateFim%><br>
    <br><br>


    <form method="post" action="criarEventos_criar">

        Nome do Evento: <br><input type="text" id="nomeEv" name="nomeEv" required/><br>
        Descrição do Evento: <br><input type="textarea" id="descEv" name="descEv" required/><br>
        Sala:<select id="sala" name="salaID">
            <c:forEach items="${listSalas}" var="sala">            
                <option value="${sala.getId()}">${sala.getName()}</option>          
            </c:forEach> 
        </select>
        <input type="hidden" value="<%= request.getParameter("dataIn")%>" id="dataIn" name="dataIn"/>
        <input type="hidden" value="<%= request.getParameter("dataFim")%>" id="dataFim" name="dataFim"/>
        <br>  <br><input type="submit" value="Criar" /> <br>
    </form> 
    <br>
    <input type="button" onclick ="history.back()" value="Voltar" />
</div>
<%@include file="footer.jsp" %>
