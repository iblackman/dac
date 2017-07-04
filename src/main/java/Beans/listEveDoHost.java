/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.EventsDAO;
import Model.Events;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caio
 */
@WebServlet(name = "listEveDoHost", urlPatterns = {"/listEveDoHost"})
public class listEveDoHost extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      EventsDAO evDao = new EventsDAO();
      Users user = (Users) request.getSession().getAttribute("user");
         List<Events> list = evDao.findByEventguestUser(user);
      request.setAttribute("listaDeEventos", list);
        request.getRequestDispatcher("listEveDoHost.jsp").forward(request, response); 
        
        
    }

}
