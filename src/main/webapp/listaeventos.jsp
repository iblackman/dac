<%-- 
    Document   : ListaEventos
    Created on : 20/06/2017, 21:37:54
    Author     : caio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="menu.jsp"/>
<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 

<div id="conteudo"> 
    <h1> LISTA DE EVENTOS</h1>
    <c:choose>
        <c:when test="${!list.isEmpty()}"> 
            <table id="listagem" >
                <thead>
                    <tr>
                        <th>Nome</th>         
                        <th>Limite das Inscrições</th>
                        <th>Vagas</th>
                        <th>Descrição</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="evento"> 
                        <tr> 
                            <td>${evento.getName()}</td>            
                            <td>${evento.getEnddt()}</td>
                            <td>${evento.getMaxguests()}</td>
                            <td>${evento.getDescription()}</td>
                        </tr> 
                    </c:forEach> 
                </tbody>
            </table> 
        </c:when>

        <c:otherwise>
            Nenhum evento disponível!
        </c:otherwise>
    </c:choose>
</div>

<%@include file="footer.jsp" %>

