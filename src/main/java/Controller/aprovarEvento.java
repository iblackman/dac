/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventsDAO;
import Model.Events;
import Model.StatusEvent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "aprovarEvento", urlPatterns = {"/aprovarEvento"})
public class aprovarEvento extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEv = Integer.parseInt(request.getParameter("idEv"));
        
        EventsDAO evDao = new EventsDAO();
        
        Events ev = evDao.findById(idEv);
        
       ev.setStatus(StatusEvent.CREATED);
       
       
       request.getRequestDispatcher("ListarEventosWaitStatus").forward(request, response);
    }
    
}
