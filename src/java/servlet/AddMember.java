/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NamePasswordDAO;
import dao.NamePasswordDAOFactory;

/**
 *
 * @author yuyun
 */
@WebServlet(name = "AddMember", urlPatterns = {"/addMember"})
public class AddMember extends HttpServlet {
    private ConcurrentSkipListMap<String,String> members;
    @Override
    public void init(){
        members = (ConcurrentSkipListMap)this.getServletContext().getAttribute("members");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");  
        PrintWriter pw = response.getWriter();
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");      
        members.put(name, password);
        
       
        NamePasswordDAO np = NamePasswordDAOFactory.getNamePasswordDAO();
        np.addNamePassword(name, password);
        
        pw.print("/HibernateLogin/htmlFiles/BasicData.html");
    }


}
