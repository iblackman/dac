package Beans;

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

        String nomeEv = request.getParameter("nomeEv");
        String descEv = request.getParameter("descEv");
        Date iniIns = null;
        try {
            iniIns = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("iniIns"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fimIns = null;
        try {
            fimIns = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fimIns"));
        } catch (ParseException ex) {
            Logger.getLogger(criarEvento_salas.class.getName()).log(Level.SEVERE, null, ex);
        }
        int salaID = parseInt(request.getParameter("salaID"));

    }

}
