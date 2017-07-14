package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ResourcesDAO;
import Model.Resources;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanches
 */
@WebServlet(urlPatterns = {"/admResource"})
public class admResource extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResourcesDAO rd = new ResourcesDAO();
        List<Resources> lr = new ArrayList<>();
        
        lr = rd.findAll();
        
        request.setAttribute("lr", lr);

        request.getRequestDispatcher("admResource.jsp").forward(request, response);

    }
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResourcesDAO rd = new ResourcesDAO();
        List<Resources> lr = new ArrayList<>();
        
        lr = rd.findAll();
        
        request.setAttribute("lr", lr);

        request.getRequestDispatcher("admResource.jsp").forward(request, response);

    }

}
