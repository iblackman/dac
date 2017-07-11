package Beans;

import DAO.EventsDAO;
import DAO.EventtypesDAO;
import DAO.RoomsDAO;
import DAO.UsersDAO;
import Model.Events;
import Model.Eventtypes;
import Model.Resources;
import Model.Rooms;
import Model.StatusEvent;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        int salaID = Integer.parseInt(request.getParameter("salaID"));

        Events ev = new Events();
        ev.setName(nomeEv);
        ev.setDescription(descEv);
        
        ev.setMaxguests(10);
        ev.setStartdt(dataIn);
        ev.setEnddt(dataFim);
        
        
        Eventtypes evt = new Eventtypes();
        EventtypesDAO etDao = new EventtypesDAO();
        evt = etDao.findById(1);
        ev.setEventtypeid(evt);
        

        RoomsDAO rDao = new RoomsDAO();
        Rooms room = new Rooms();
        room = rDao.findById(salaID);
        
        ev.setRoomid(room);
        
        //TODO, não pode ser 1, tem que ser o user da
        UsersDAO udao = new UsersDAO();
        Users user = udao.findById(1);

        ev.setUserid(user);
        ev.setStatus(StatusEvent.WAITING);// (1-criado, 2-Aguardando aprovacao, 3-Cancelado) 
        
        EventsDAO s = new EventsDAO();
        s.save(ev);
        
        request.getRequestDispatcher("ferramentasadm.jsp").forward(request, response);
    }
}
