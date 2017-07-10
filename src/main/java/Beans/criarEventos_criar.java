package Beans;

import DAO.EventsDAO;
import DAO.RoomsDAO;
import Model.Events;
import Model.Rooms;
import static Model.StatusEvent.WAITING;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/criarEventos_criar"})
public class criarEventos_criar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date dataIn = null;
        try {
            dataIn = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataIn"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date dataFim = null;
        try {
            dataFim = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataFim"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nomeEv = request.getParameter("nomeEv");
        String descEv = request.getParameter("descEv");
        

     //   int sala = parseInt(request.getParameter("salaID"));
       // RoomsDAO rDao = new RoomsDAO();
        //Rooms r = rDao.findById(sala);
        
        
        int cap = 20;
        
        Events ev = new Events(nomeEv,descEv,WAITING, dataIn,dataFim,cap );

        
        EventsDAO evD = new EventsDAO();
        evD.save(ev);
        
             request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);
        

    }

}
