
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="menu.jsp" %>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="index"> 
    <div id="conteudo"> 
        <h1> Evento:${ev.getName()} </h1>

        <c:choose>
            <c:when test="${!userList.isEmpty()}"> 
                <table id="listagem" >
                    <thead>
                        <tr>
                            <th>Nome</th>         
                            <th>Presente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userList}" var="usr"> 
                            <tr> 
                                <td>${usr.getName()}</td>            
                                <td>PRESENTE!</td>
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