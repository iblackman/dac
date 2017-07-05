/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.EventguestsDAO;
import DAO.EventsDAO;
import Model.Eventguests;
import Model.Events;
import Model.Users;
import java.io.IOException;
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
@WebServlet(name = "listEventInsc", urlPatterns = {"/listEventInsc"})
public class listEventInsc extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventsDAO event = new EventsDAO();

        Users user = (Users)request.getSession().getAttribute("user");
        
       
        
        List<Events> list = event.findByEventguestUser(user);
        request.setAttribute("list", list);
        request.getRequestDispatcher("listEventInsc.jsp").forward(request, response);
        
        
    }


}
