<%-- 
    Document   : index
    Created on : May 14, 2017, 8:59:22 PM
    Author     : Igor
--%>

<%@page import="Model.Events"%>
<%@page import="DAO.EventsDAO"%>
<%@page import="Model.Users"%>
<%@page import="DAO.UsersDAO"%>
<%@page import="org.hibernate.Session"%>
<%@page import="DAO.HibernateSessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  Session s = HibernateSessionFactory.getSession();
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/estilo.css" type="text/css" /> 
        <link rel="stylesheet" href="./CSS/tabela.css" type="text/css" />         <title>JSP Page</title>
    </head>
    <body>

        <%@include file="menu.jsp" %>


<div id="index">
    <br>
        <h1>Univeridade Federal Fluminense</h1>


        <h3>IC - Sistemas de Informação - 2017.2</h3>

        <h3> Aplicação de Gerenciamento de Eventos da Universidade</h3>
<br>
<br>
<br>

        Esta aplicação web foi desenvolvida como trabalho final da disciplina de Desenvolvimento de Aplicações Coorporativas. 
        Nela o Grupo Mestre Splinter deveria criar de um sistema Web utilizando as técnicas e tecnologias
        abordadas na disciplina como o JSP, SERVLET entre outros.
        <p>
            Nesta aplicação você pode encontrar as seguintes funcionalidades:</p>
        Criação de Eventos
        <br>* Inscrição em Eventos
        <br>* CRUD de salas
        <br>* Listagem de Eventos
        <br>* etc..
</div>


        <%@include file="footer.jsp" %>
    </body>
</html>
