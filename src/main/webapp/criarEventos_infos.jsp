<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


Data Inicio do Evento: <%= request.getParameter("dataEv")%><br>
Data Fim do Evento: <%= request.getParameter("dataFim")%><br>
<br>
<form method="post" action="criarEventos_criar">

    Nome do Evento: <br><input type="text" id="nomeEv" name="nomeEv"/><br>
    Descrição do Evento: <br><input type="textarea" id="descEv" name="descEv"/><br>
    Sala:<select id="sala" name="salaID">
        <c:forEach items="${listSalas}" var="sala">            
            <option value="${sala.getId()}">${sala.getName()}</option>          
        </c:forEach> 
    </select>

    <br>  <br><input type="submit" value="Criar" /> <br>
</form>    

<%@include file="footer.jsp" %>
