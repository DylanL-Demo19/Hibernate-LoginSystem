/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yuyun
 */
@WebServlet(name = "CheckNameAndPassword", urlPatterns = {"/doCheck"})
public class CheckNameAndPassword extends HttpServlet {
        private ConcurrentSkipListMap<String,String> members;
    @Override
    public void init(){
        members =(ConcurrentSkipListMap<String,String>) this.getServletContext().getAttribute("members");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");        
        try (PrintWriter out = response.getWriter()) {
            //get check index
            int checkNumber = Integer.parseInt(request.getParameter("checkNumber"));
            switch (checkNumber) {
                case 0:
                    {
                        //check name from login
                        String name = request.getParameter("name");
                        String memberPassword = members.get(name);
                        if(memberPassword == null){
                            out.print("-1");
                        }else{
                            //put infomation to client
                            out.print("inputPassword.html?" + name);
                        }       break;
                    }
                case 1:
                    {
                        //check password
                        String name = request.getParameter("name");
                        String password = request.getParameter("password");
                        String memberPassword = members.get(name);
                        if(memberPassword.equals(password)){
                            out.print("welcome.html");
                        }else{
                            out.print("-1");
                        }       break;
                    }
                case 2:
                    {
                        //check name from add member
                        String name = request.getParameter("name");
                        String memberPassword = members.get(name);
                        if(memberPassword == null){
                            out.print("1");
                        }else{
                            out.print("-1");
                        }       break;
                    }
            }
        }
    }
}
