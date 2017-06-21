<%-- 
    Document   : index
    Created on : May 14, 2017, 8:59:22 PM
    Author     : Igor
--%>

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
        
        <%@include file="T_Menu.jsp" %>
        
        
        
        <h1>Página inicial com o blá blá blá de ser um projeto de uma matéria da UFF dos alunos blá blá blá</h1>
        
        
        
        <%@include file="T_Footer.jsp" %>
    </body>
</html>
