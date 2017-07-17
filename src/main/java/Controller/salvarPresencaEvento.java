/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventguestsDAO;
import DAO.EventsDAO;
import DAO.UsersDAO;
import Model.Eventguests;
import Model.Events;
import Model.StatusEventGuest;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caiop
 */
@WebServlet(name = "salvarPresencaEvento", urlPatterns = {"/salvarPresencaEvento"})
public class salvarPresencaEvento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int usrId = Integer.parseInt(request.getParameter("usrId"));
        int presenca = Integer.parseInt(request.getParameter("presenca"));
        
        UsersDAO usrDAO = new UsersDAO();
        Users usr = usrDAO.findById(usrId);
        
        EventsDAO evDAO = new EventsDAO();
        Events ev = evDAO.findById(eventId);
        
        EventguestsDAO evgDAO = new EventguestsDAO();
        Eventguests evg = new Eventguests();
        
        evg.setUsers(usr);
        evg.setEvents(ev);
        evg.setStatus(StatusEventGuest.OK);
        evg.setPresence(presenca);
        
        evgDAO.save(evg);
        
        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);
        
        

    }

}
