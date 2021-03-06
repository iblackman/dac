<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="conteudo"> 
    <h1> LISTA DE EVENTOS CRIADOS POR MIM</h1>
    <div id="index"> 
        <c:choose>
            <c:when test="${!list.isEmpty()}"> 
                <table id="listagem" >
                    <thead>
                        <tr>
                            <th>Evento</th>         
                            <th>Data</th>
                            <th>Lista de Inscritos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="evento"> 
                            <tr> 
                                <td>${evento.getName()}</td>            
                                <td>${evento.getStartdt()}</td>
                                <td>
                                    <form method="post" action="ListadeInscritosNoEventoX">
                                        <input type="submit" value="Ver inscritos">
                                        <input type="hidden" value="${evento.getId()}" name="idEv"/>
                                    </form>
                                </td>
                            </tr> 

                        </c:forEach> 
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                Nenhum evento criado!
            </c:otherwise>
        </c:choose>

    </div>
</div>
<%@include file="footer.jsp" %>