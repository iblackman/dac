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

@WebServlet(urlPatterns = {"/SaveResource"})
public class SaveResource extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String rec = request.getParameter("rec");
        ResourcesDAO rD = new ResourcesDAO();
        Resources r = new Resources();
        r.setName(rec);
        rD.save(r);
        
        
         request.getRequestDispatcher("admResource").forward(request, response);
        
        
        
        
        
        
    }

}
