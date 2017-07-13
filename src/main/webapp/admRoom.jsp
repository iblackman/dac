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
<div id="index"> 
    <h1> LISTA DE SALS</h1>
    <c:choose>
        <c:when test="${!lroom.isEmpty()}"> 
            <table id="listagem" >
                <thead>
                    <tr>
                        <th>Nome</th> 
                        <th>Recursos</th>
                        <th>Deletar</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lroom}" var="room"> 
                        <tr> 
                            <td>${room.getName()}</td>            
                            <td>
                                <c:choose>
                                    <c:when test="${!room.getResourcesCollection()}"> 
                                        <c:forEach items="${room.getResourcesCollection()}" var="resources"> 
                                            ${resources.getName()} <br>
                                        </c:forEach> 
                                    </c:when>
                                    <c:otherwise>
                                        Nenhum recurso nesta sala!
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td>${room.getDescription()}</td>
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

