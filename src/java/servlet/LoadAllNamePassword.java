/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypackage.NamePassword;
import dao.NamePasswordDAO;
import dao.NamePasswordDAOFactory;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.servlet.ServletContext;

/**
 *
 * @author student
 */
@WebServlet(name = "LoadAllNamePassword", urlPatterns = {"/LoadAllNamePassword"}, loadOnStartup = 1)
public class LoadAllNamePassword extends HttpServlet {
    @Override 
    public void init(){        
        ServletContext sc = getServletContext();
        ConcurrentSkipListMap<String,String> members = new ConcurrentSkipListMap<>();    
        NamePasswordDAO dao = NamePasswordDAOFactory.getNamePasswordDAO();
        List<NamePassword> list = dao.getAllNamePassword();
        for(NamePassword np : list){
            members.put(np.getName(), np.getPassword());
        }
        sc.setAttribute("members", members);
    }
}
