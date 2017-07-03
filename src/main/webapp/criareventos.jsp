<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 



<form method="get" action="criarEvento_salas">
    Data do Evento: <br><input type="date" id="dataEv" name="dataEv"/><br><br>
    1/2 <input type="submit" value="Escolher Sala" /> <br>
</form>   

<%@include file="footer.jsp" %>

