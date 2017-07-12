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

@WebServlet(name = "cancelarInscEvent", urlPatterns = {"/cancelarInscEvent"})
public class cancelarInscEvent extends HttpServlet {

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEv = Integer.parseInt(request.getParameter("idEv"));
                
        Users user = (Users) request.getSession().getAttribute("user");

        
        EventguestsDAO eg = new EventguestsDAO();
        
        List <Eventguests> evl= eg.findByEventUser(idEv, user.getId());
              
        eg.delete(evl.get(1));


        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);

    }

}
