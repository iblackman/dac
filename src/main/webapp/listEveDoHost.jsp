<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="menu.jsp" %>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 
<div id="conteudo"> 
    <h1> LISTA DE INSCRITOS</h1>
    <c:if test="${!list.isEmpty()}"> 

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
                        <td> ${evento.getId()}<form method="post" action="cacelarEvent">

                                <input type="submit" value="Ver inscritos">
                                <input type="hidden" value="${evento}" name="idEv"/>
                            </form>
                        </td>
                    </tr> 
                </c:forEach> 

            </c:if>
            <c:if test="${list.isEmpty()}">
                Nenhum evento criado evento!
            </c:if>

        </tbody>
    </table> 
</div>






<%@include file="footer.jsp" %>