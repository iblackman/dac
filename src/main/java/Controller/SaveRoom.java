/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.RoomsDAO;
import Model.Rooms;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caiops
 */
@WebServlet(name = "SaveRoom", urlPatterns = {"/SaveRoom"})
public class SaveRoom extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String sala = request.getParameter("sala");
        RoomsDAO rD = new RoomsDAO();
        Rooms r = new Rooms();
        r.setName(sala);
        rD.save(r);
        
        
         request.getRequestDispatcher("admRoom").forward(request, response);
        
        
        
        
        
    }

   

}
