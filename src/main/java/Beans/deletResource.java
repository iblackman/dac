/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.ResourcesDAO;
import Model.Resources;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanches
 */
@WebServlet(name = "deletResource", urlPatterns = {"/deletResource"})
public class deletResource extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int recID = Integer.parseInt(request.getParameter("RecId"));

        ResourcesDAO rD = new ResourcesDAO();
        Resources r = new Resources();
        r = rD.findById(recID);
        rD.delete(r);

        request.getRequestDispatcher("admResource").forward(request, response);
    }
}
