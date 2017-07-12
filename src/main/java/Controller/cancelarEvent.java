/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

@WebServlet(name = "cancelarEvent", urlPatterns = {"/cancelarEvent"})
public class cancelarEvent extends HttpServlet {

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEv = Integer.parseInt(request.getParameter("idEv"));
                
        Users user = (Users) request.getSession().getAttribute("user");
        
        EventsDAO evD = new EventsDAO();
        
        //pra cancelar o evento acredito que basta deletar o evento, e os eventguests vao ser deletados em cascade
        evD.delete(idEv);
        
//        Events event = evD.findById(idEv);
//        
//        EventguestsDAO eg = new EventguestsDAO();
//        List<Eventguests> egs = eg.findByEventUser(event, user);
//              
//        if(egs.size() > 0){
//            eg.delete(egs.get(0));
//        }else{
//            request.setAttribute("message", "Não existe a combinação eventguest");
//        }

        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);

    }

}
