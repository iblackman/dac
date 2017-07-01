package Beans;

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

@WebServlet(name = "listarEventos", urlPatterns = {"/listarEventos"})
public class listarEventos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventsDAO edao = new EventsDAO();
        List<Events> list = edao.findAll();
        request.setAttribute("listaDeEventos", list);
        request.getRequestDispatcher("listaeventos.jsp").forward(request, response);
    }

}
