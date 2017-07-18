
<%@page import="Model.StatusEventGuest"%>
<%@page import="Model.Users"%>
<%@page import="java.util.List"%>
<%@page import="Model.Eventguests"%>
<%@page import="Model.Events"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="menu.jsp" %>

<%
    Events ev = (Events) request.getAttribute("ev");
    
    List<Eventguests> evguests = (List<Eventguests>)request.getAttribute("evguests");
    
%>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="index"> 
    <div id="conteudo"> 
        <h1> Evento: ${ev.getName()} </h1>

        <% if(evguests != null && !evguests.isEmpty()){ %>
                <table id="listagem" >
                    <thead>
                        <tr>
                            <th>Nome</th>         
                            <th>Situação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Eventguests evg: evguests){ %>
                            <tr> 
                                <td><%= evg.getUsers().getName()%></td>            
                                <td>
                                    <form method="post" action="salvarPresencaEvento">
                                        <input type="hidden" id="usrId" name="usrId" value="<%= evg.getUsers().getId()%>" />
                                        <input type="hidden" id="eventId" name="eventId" value="${ev.getId()}" />
                                        <% if(evg.getStatus() == StatusEventGuest.OK){ %>
                                        <input type="radio" id="presenca" name="presenca" value="0" checked> Presente
                                        <input type="radio" id="presenca" name="presenca" value="2"> Faltoso
                                        <% }else{ %>
                                        <input type="radio" id="presenca" name="presenca" value="0" > Presente
                                        <input type="radio" id="presenca" name="presenca" value="2" checked> Faltoso
                                        <% } %>
                                        <input type="submit" value="Salvar" />
                                    </form>
                                </td>
                            </tr> 

                        <% } %> 
                    </tbody>
                </table> 
            <% }else{ %>
                Nenhum Inscrito no evento!
            <% }%>
    </div>
</div>

<%@include file="footer.jsp" %>