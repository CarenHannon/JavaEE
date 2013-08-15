/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ControllerServlet", 
            loadOnStartup = 1,
            urlPatterns = {"/ShowDeps", "/ShowEmps" , "ShowProjs", "deptView", "empView", "projView"})

public class ControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/ShowDeps")) {
            // TODO: Implement category request
            userPath = "/showDepartments";

        // if cart page is requested
        } else if (userPath.equals("/ShowEmps")) {
            // TODO: Implement cart page request

            userPath = "/showEmployees";

        // if checkout page is requested
        } else if (userPath.equals("/ShowProjs")) {
            // TODO: Implement checkout page request
            userPath = "/showProjects";
            
        } else if (userPath.equals("/empView")) {
            // TODO: Implement checkout page request
            userPath = "/empView";
        } else if (userPath.equals("/deptView")) {
            // TODO: Implement checkout page request
            userPath = "/deptView";
        } else if (userPath.equals("/projView")) {
            // TODO: Implement checkout page request
            userPath = "/projView";
        }
        

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


