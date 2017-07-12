/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "inscEmEventos", urlPatterns = {"/inscEmEventos"})
public class inscEmEventos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventsDAO edao = new EventsDAO();
        List<Events> list = edao.findAll();

        request.setAttribute("list", list);

        request.setAttribute("listaDeEventos", list);

        request.getRequestDispatcher("inscEmEventos.jsp").forward(request, response);

    }

}
