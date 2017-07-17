<%-- 
    Document   : ListaEventos
    Created on : 20/06/2017, 21:37:54
    Author     : caio
--%>
<%@page import="Model.Resources"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="menu.jsp"/>
<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="index"> 
    <h1>SALA: ${roomid.getName()} </h1>

    <c:choose>
        <c:when test="${!list.isEmpty()}"> 
            <table id="listagem" >
                <thead>
                    <tr>              
                        <th>Recursos</th>
                        <th>Presente</th>
                        <th>Adicionar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="resources"> 
                        <tr> 
                            <td>${resources.getName()}</td>
                            <td><input type="radio" name="presente" value=""></td>
                            <td><input type="submit" value="Adicionar"></td>
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

