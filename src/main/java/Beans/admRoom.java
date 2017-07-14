package Beans;

import DAO.RoomsDAO;
import Model.Rooms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admRoom", urlPatterns = {"/admRoom"})
public class admRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoomsDAO rD = new RoomsDAO();
        List<Rooms> lroom = new ArrayList<>();
        lroom = rD.findAll();

        request.setAttribute("lroom", lroom);

        request.getRequestDispatcher("admRoom.jsp").forward(request, response);

    }

}
