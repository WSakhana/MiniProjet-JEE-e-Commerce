/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import dao.ClientDao;
import entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author islem
 */
public class ModifierClientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try
        {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String login = request.getParameter("login");
            String mdp = request.getParameter("mdp");
            String etat=request.getParameter("etat");
            int etatf=0;
            if(etat.equals("Bloqué"))
                etatf=0;
            else
                etatf=1;
            int a = Integer.parseInt(request.getParameter("date_a"));
            int m = Integer.parseInt(request.getParameter("date_m"));;
            int j = Integer.parseInt(request.getParameter("date_j"));;
                
            Date dt = new Date(a, m, j);
            
            
            int age = 2014 - a ;
            
            
            Client ar = new Client(login,mdp,nom,prenom,null,etatf);
            System.out.println("CLIENT");
            ClientDao dao = new ClientDao();
            System.out.println("CLIENTDAO");
            
            if(dao.modifier(ar))
            {
                System.out.println("sucess");
                response.sendRedirect("Admin/CompteListe.jsp?add=success");
            }else
            {
                System.out.println("fail");
                response.sendRedirect("Admin/CompteListe.jsp?add=fail");
            }
            
        }catch( Exception ex)
        {
            System.out.println("excep");
            response.sendRedirect("Admin/CompteListe.jsp?add=fail");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
