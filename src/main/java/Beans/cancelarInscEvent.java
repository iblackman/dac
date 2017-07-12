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
        //pegar evento a aartir do id
        Events ev = new EventsDAO().findById(idEv);
        //pegar eventGuest passando event e user
        List <Eventguests> egs = eg.findByEventUser(ev, user);
        //checar se a lista veio com algum resultado ou não
        if(egs.size() > 0){
            eg.delete(egs.get(0));
        }else{
            request.setAttribute("message", "Nao existe inscricao desse usuario nesse evento.");
        }


        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);

    }

}
