<%@include file="menu.jsp" %>

<h1>CRIAR EVENTOS</h1>

<link rel="stylesheet" href="./CSS/tabela.css" type="text/css" /> 


<div id="index"> 
    <form method="get" action="criarEvento_salas">
        INICIO do Evento: <br>
        Data: <input type="date" id="dataIn" name="dataIn"/><br>
        Hora: <input type="time" id="horaIn" name="horaIn"/><br>
        <br>
        <br>
        FIM do Evento: <br>
        Data: <input type="date" id="dataFim" name="dataFim"/><br>
        Hora: <input type="time" id="horaFim" name="horaFim"/><br>
        <br>
        <br>
        1/2 <input type="submit" value="Escolher Sala" /> <br>
    </form>   
</div>

<%@include file="footer.jsp" %>

