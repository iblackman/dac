
<%@page import="Model.Events"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="menu.jsp" %>

<%
    Events ev = (Events) request.getAttribute("ev");
    
%>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="index"> 
    <div id="conteudo"> 
        <h1> Evento: ${ev.getName()} </h1>

        <c:choose>
            <c:when test="${!userList.isEmpty()}"> 
                <table id="listagem" >
                    <thead>
                        <tr>
                            <th>Nome</th>         
                            <th>Situação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userList}" var="usr"> 


                            <tr> 
                                <td>${usr.getName()}</td>            
                                <td>
                                    <form method="post" action="salvarPresencaEvento">
                                        <input type="hidden" id="usrId" name="usrId" value="${usr.getId()}" />
                                        <input type="hidden" id="eventId" name="eventId" value="${ev.getId()}" />
                                        <input type="radio" id="presenca" name="presenca" value="1" checked> Presente
                                        <input type="radio" id="presenca" name="presenca" value="0"> Faltoso
                                        <input type="submit" value="Salvar" />
                                    </form>
                                </td>
                            </tr> 

                        </c:forEach> 
                    </tbody>
                </table> 
            </c:when>
            <c:otherwise>
                Nenhum Inscrito no evento!
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@include file="footer.jsp" %>