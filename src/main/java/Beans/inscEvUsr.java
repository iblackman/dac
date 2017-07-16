package Beans;


import DAO.EventguestsDAO;
import DAO.EventsDAO;
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

@WebServlet(urlPatterns = {"/inscEvUsr"})
public class inscEvUsr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventsDAO evD = new EventsDAO();
        int idEvent = Integer.parseInt(request.getParameter("idEv"));
        Users user = (Users) request.getSession().getAttribute("user");
        Events ev = evD.findById(idEvent);
        
        
        Eventguests evg = new Eventguests(ev,user);

        EventguestsDAO evGuests = new EventguestsDAO();
        
        evGuests.save(evg);
        
     
        
          request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);
    }

}
