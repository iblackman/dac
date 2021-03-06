package Beans;

import DAO.RoomsDAO;
import Model.Rooms;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
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


            Date dataIn = null;
            String[] datetime;
        try {
            datetime = request.getParameter("dataIn").split("T");
            dataIn = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(datetime[0]+" "+datetime[1]);
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }
   
           Date dataFim = null;
           String[] datetime2;
        try {
            datetime2 = request.getParameter("dataFim").split("T");
            dataFim = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(datetime2[0]+" "+datetime2[1]);
            
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        RoomsDAO salas = new RoomsDAO();
        List<Rooms> rooms = salas.findAvailableByDate(dataIn,dataFim);
                
        request.setAttribute("listSalas", rooms);
        request.setAttribute("dataIn",dataIn );
        request.setAttribute("dataFim", dataFim);
        
        request.getRequestDispatcher("criarEventos_infos.jsp").forward(request, response);

    }

}
