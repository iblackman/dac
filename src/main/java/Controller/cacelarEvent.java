/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventsDAO;
import Model.Events;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cacelarEvent", urlPatterns = {"/cacelarEvent"})
public class cacelarEvent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventsDAO ev = new EventsDAO();
        int id = Integer.parseInt(request.getParameter("idEv"));
        ev.delete(id);
     
     
     request.getRequestDispatcher("listEventInsc.jsp").forward(request, response);
        
        
        
    }

}
