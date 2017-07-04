package Beans;

import DAO.RoomsDAO;
import Model.Rooms;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "criarEvento_salas", urlPatterns = {"/criarEvento_salas"})
public class criarEvento_salas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date dataEv = null;
        try {
            dataEv = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataEv"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          Date dataFim = null;
        try {
            dataFim = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataFim"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }

        RoomsDAO salas = new RoomsDAO();
        List<Rooms> rooms = salas.findAvailableByDate(dataEv,dataFim);
        
        request.setAttribute("dataEv", dataEv);
        request.setAttribute("dataFim", dataFim);
        request.setAttribute("listSalas", rooms);
        
        request.getRequestDispatcher("criarEventos_infos.jsp").forward(request, response);

    }

}
