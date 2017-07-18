<%-- 
    Document   : ListaEventos
    Created on : 20/06/2017, 21:37:54
    Author     : caio
--%>
<%@page import="Model.Rooms"%>
<%@page import="Model.Resources"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="menu.jsp"/>

<%
List<Resources> resources = (List<Resources>)request.getAttribute("list");
  List<Resources> ltTem = (List<Resources>)request.getAttribute("listTem");
  Rooms room = (Rooms)request.getAttribute("room");
%>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="index"> 
    <h1>SALA: ${roomid.getName()} </h1>

    <c:choose>
        <c:when test="${list != null && !list.isEmpty()}"> 
            <form method="post" action="admSaveResources">
                <table id="listagem" >
                    <thead>
                        <tr>              
                            <th>Recursos</th>
                            <th>Presente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for(Resources res : resources){ %>
                            <tr> 
                                <td><%=res.getName()%></td>
                                <% if(ltTem != null && ltTem.contains(res)){ %>
                                <td><input type="checkbox" name="recursos" value="<%=res.getId()%>" checked></td>
                                 <%}else{ %>
                                <td><input type="checkbox" name="recursos" value="<%=res.getId()%>" ></td>
                                <% } %>
                            </tr> 
                        <% } %>
                    </tbody>
                </table> 
                <input type="hidden" name="roomId" value="<%= room.getId() %>"/>
                <input type="submit" value="Salvar"/>
            </form>
        </c:when>

        <c:otherwise>
            Nenhum evento disponível!
        </c:otherwise>
    </c:choose>

</div>

<%@include file="footer.jsp" %>

