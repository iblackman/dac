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
<%  Session s = HibernateSessionFactory.getSession();  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/estilo.css" type="text/css" /> 
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        <h1>Página inicial com o blá blá blá de ser um projeto de uma matéria da UFF dos alunos blá blá blá</h1>
        <%
            //Testes apenas, esta errado fazer desse jeito, o controller (servlet) que deve processar (pelo menos eu acho)
        UsersDAO udao = new UsersDAO();
        Users user = udao.findById(1);
        %>
        <p><%=user.getName()%></p>
        <p><%=user.getUsertypeid()%></p>

        
        <%
            //Testes apenas, esta errado fazer desse jeito, o controller (servlet) que deve processar (pelo menos eu acho)
        EventsDAO evdao = new EventsDAO();
        Events event = evdao.findById(1);
        %>
        <p><%=event.getName()%></p>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
