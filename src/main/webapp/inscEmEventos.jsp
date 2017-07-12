<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="conteudo"> 
    <h1> LISTA </h1>

    <c:choose>
        <c:when test="${!list.isEmpty()}"> 
            <table id="listagem" >
                <thead>
                    <tr>
                        <th>Evento</th>         
                        <th>Data</th>
                        <th>Inscri��o</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="evento"> 
                        <tr> 
                            <td>${evento.getName()}</td>            
                            <td>${evento.getStartdt()}</td>
                            <td>
                                <form method="post" action="inscEvUsr">
                                    <input type="submit" value="gogogo">
                                    <input type="hidden" value="${evento.getId()}" name="idEv"/>
                                </form>
                            </td>
                        </tr> 

                    </c:forEach> 
                </tbody>
            </table> 
        </c:when>
        <c:otherwise>
            Voc� n�o possui nenhuma inscri��o em eventos!
        </c:otherwise>
    </c:choose>
    <br>
    <input type="button" onclick ="history.back()" value="Voltar" />
</div>

<%@include file="footer.jsp" %>