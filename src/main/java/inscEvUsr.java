
import DAO.EventguestsDAO;
import DAO.EventsDAO;
import Model.Eventguests;
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

        EventguestsDAO evGuests = new EventguestsDAO();
        Eventguests evg = new Eventguests();
        evg.setEvents(evD.save(evD.findById(idEvent)));
        evg.setUsers(user);
        evg.setPresence(0);
        evg.setStatus(StatusEventGuest.OK);
        
          request.getRequestDispatcher("inscEmEventos.jsp").forward(request, response);
    }

}
