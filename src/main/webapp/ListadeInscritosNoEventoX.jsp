
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="menu.jsp" %>

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
                            <th>Presente</th>
                            <th>Faltoso</th>
                            <th>Salvar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userList}" var="usr"> 
                            <tr> 
                        <form method="post" action="salvarPresencaEvento">
                            <td>${usr.getName()}</td>            
                            <td><input type="radio" name="presenca" value="presente" checked></td>
                            <td><input type="radio" name="presenca" value="faltou">!</td>
                            <td><input type="submit" value="Salvar" /></td>
                            
                            <input type="hidden" name="usrId" value="${usr.getId()}" />
                            <input type="hidden" name="eventId" value="${ev.getId()}" />
                        </form>
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