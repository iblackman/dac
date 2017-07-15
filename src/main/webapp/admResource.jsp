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
    <h1>LISTA DE RECURSOS</h1>
    <p>
    <form method="post" action="SaveResource">
        Cadastrar recurso: <input type="text" id="rec" name="rec"/> 
        <input type="submit" value="Cadastrar" /> <br>
    </form>         
    <p>

        <c:choose>
            <c:when test="${!lr.isEmpty()}"> 
            <table id="listagem" >
                <thead>
                    <tr>
                        <th>Recurso</th>
                        <th>Deletar</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lr}" var="lr"> 
                        <tr> 
                            <td>${lr.getName()}</td>            
                            <td>
                                <form method="post" action="deletResource">
                                    <input type="hidden" value="${lr.getId()}" name="RecId" id="RecId"/>
                                    <c:choose>                                        
                                        <c:when test="${!lr.getRoomsCollection().isEmpty()}">
                                            <input type="submit" value="X" disabled >                                  
                                        </c:when>
                                        <c:otherwise>
                                            <input type="submit" value="X"  >
                                        </c:otherwise>
                                    </c:choose>
                                </form>   
                            </td>
                        </tr> 
                    </c:forEach> 
                </tbody>
            </table> 
        </c:when>

        <c:otherwise>
            Nenhum recurso cadastrado!
        </c:otherwise>
    </c:choose>
    <p><input type="button" onclick ="history.back()" value="Voltar" /> 

</div>

<%@include file="footer.jsp" %>

