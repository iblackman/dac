<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


<div id="index"> 
    <form method="get" action="criarEvento_salas">
        INICIO do Evento: <p>
        Data: <input type="datetime-local" id="dataIn" name="dataIn"/><br>
        <br>
        <br>
        FIM do Evento: <p>
        Data: <input type="datetime-local" id="dataFim" name="dataFim"/><br>
        <br>
        <br>
        1/2 <input type="submit" value="Escolher Sala" /> <br>
    </form> 
    <br>
    <input type="button" onclick ="history.back()" value="Voltar" />
</div>

<%@include file="footer.jsp" %>

