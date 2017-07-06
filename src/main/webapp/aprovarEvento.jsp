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
    <h1> LISTA </h1>
    <table id="listagem" >
        <thead>
            <tr>
                <th>Nome</th>         
                <th>Descri��o</th>
                <th>Inicio</th>
                <th>Fim</th>
                <th>Aprovar</th>
                <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listEv}" var="evento"> 
                <tr> 
                    <td>${evento.getName()}</td>            
                    <td>${evento.getDescription()}</td>
                    <td>${evento.getStartdt()}</td>
                    <td>${evento.getEnddt()}</td>
                    <td>
                        <form method="get" action="aprovarEvento">
                              <input type="submit" value="ok">
                                <input type="hidden" value="${evento.getId()}" name="idEv"/>                                               
                        </form>                                    
                    </td>
                    <td>
                        <form method="get" action="removerEvento">
                            
                              <input type="submit" value="X">
                                <input type="hidden" value="${evento.getId()}" name="idEv"/>
                            
                        </form>                                    
                    </td>
                </tr> 
            </c:forEach> 
        </tbody>
    </table> 
</div>

<%@include file="footer.jsp" %>

