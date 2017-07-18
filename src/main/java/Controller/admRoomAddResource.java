/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ResourcesDAO;
import DAO.RoomsDAO;
import Model.Resources;
import Model.Rooms;
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
 * @author caiop
 */
@WebServlet(name = "admRoomAddResource", urlPatterns = {"/admRoomAddResource"})
public class admRoomAddResource extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int roomid = Integer.parseInt(request.getParameter("roomid"));
        
        ResourcesDAO rD =new ResourcesDAO();
        List <Resources> lr = rD.findAll();
        
        RoomsDAO roomD = new RoomsDAO();
        Rooms a = roomD.findById(roomid);
        request.setAttribute("list", lr);
         
        List<Resources> listTem = (List<Resources>) a.getResourcesCollection();
        request.setAttribute("listTem", listTem);

        request.setAttribute("room",a );

        request.getRequestDispatcher("addResourcesRoom.jsp").forward(request, response);

    }

}
