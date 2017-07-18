package Controller;

import DAO.EventsDAO;
import DAO.EventguestsDAO;
import Model.Eventguests;
import Model.Events;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListadeInscritosNoEventoX", urlPatterns = {"/ListadeInscritosNoEventoX"})
public class ListadeInscritosNoEventoX extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventsDAO evDao = new EventsDAO();
        Events ev = evDao.findById(Integer.parseInt(request.getParameter("idEv")));

        EventguestsDAO evgDao = new EventguestsDAO();

        List<Eventguests> evGuestsList = evgDao.findByEvent(ev);
        List<Users> userList = new ArrayList<Users>();

        Users usr = new Users();

        for (Eventguests c : evGuestsList) {
            usr = c.getUsers();
            userList.add(usr);
        }
        
        request.setAttribute("evguests", evGuestsList);
        
        request.setAttribute("userList", userList);
        
        request.setAttribute("ev", ev);
        request.getRequestDispatcher("ListadeInscritosNoEventoX.jsp").forward(request, response);

    }

}
