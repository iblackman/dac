package Controller;

import DAO.EventsDAO;
import Model.Events;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ListarEventosWaitStatus", urlPatterns = {"/ListarEventosWaitStatus"})
public class ListarEventosWaitStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventsDAO evDao = new EventsDAO();
        List<Events> listEv = evDao.findWaiting();

        request.setAttribute("list", listEv);
        request.getRequestDispatcher("aprovarEvento.jsp").forward(request, response);

    }

}
