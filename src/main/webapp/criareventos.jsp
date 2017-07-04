<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 



<form method="get" action="criarEvento_salas">
    Data do INICIO do Evento: <br><input type="date" id="dataIn" name="dataIn"/><br><br>
    Data do FIM do Evento: <br><input type="date" id="dataFim" name="dataFim"/><br><br>
    1/2 <input type="submit" value="Escolher Sala" /> <br>
</form>   

<%@include file="footer.jsp" %>

