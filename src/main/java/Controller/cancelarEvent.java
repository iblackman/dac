/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventguestsDAO;
import DAO.EventsDAO;
import Model.Events;
import Model.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cancelarEvent", urlPatterns = {"/cancelarEvent"})
public class cancelarEvent extends HttpServlet {

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEv = Integer.parseInt(request.getParameter("idEv"));
                
        Users user = (Users) request.getSession().getAttribute("user");
        
        EventsDAO evD = new EventsDAO();
        Events event = evD.findById(idEv);
        
        
        EventguestsDAO eg = new EventguestsDAO();
        eg.findByEventUser(event, user);
              

        EventguestsDAO ev = new EventguestsDAO();


        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);

    }

}
