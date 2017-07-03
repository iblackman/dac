<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


Data do Evento: <%= request.getParameter("dataEv")%><br>
<br>
<form method="post" action="criarEventos_criar">
    <input type="hiden" id="iniIns" value="<%= request.getParameter("dataEv")%>" name="data"/>
    Nome do Evento: <br><input type="text" id="nomeEv" name="nomeEv"/><br>
    Descrição do Evento: <br><input type="textarea" id="descEv" name="descEv"/><br>
    Inicio das inscrições: <br><input type="date" id="iniIns" name="iniIns"/><br>
    Fim das inscrições: <br><input type="date" id="fimIns" name="fimIns"/><br>
    Sala:<select id="sala" name="salaID">
        <c:forEach items="${listSalas}" var="sala">            
            <option value="${sala.getId()}">${sala.getName()}</option>
            
            
        </c:forEach> 
    </select>

    <br>  <br><input type="submit" value="Criar" /> <br>
</form>    

<%@include file="footer.jsp" %>
