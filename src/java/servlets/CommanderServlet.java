/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CommandeDao;
import dao.LigneCommandeDao;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import panier.LignePanier;
import panier.Panier;

/**
 *
 * @author Walid
 */
public class CommanderServlet extends HttpServlet
{

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
            throws ServletException, IOException
    {
        if (request.getSession().getAttribute("client") == null)
        {
            response.sendRedirect("index.jsp?con");
            return;
        }

        try
        {

            Panier p = (Panier) request.getSession().getAttribute("panier");
            Client c = (Client) request.getSession().getAttribute("client");

            double prixT = 0;

            for (LignePanier lp : p.getLignesPanier())
            {
                prixT += lp.getQuantite() * lp.getArticle().getPrix();
            }

            CommandeDao daoc = new CommandeDao();
            daoc.add(new Commande(c.getLogin(), prixT));

            LigneCommandeDao daolc = new LigneCommandeDao();

            int idCmd = daoc.getLastID();
            for (LignePanier lp : p.getLignesPanier())
            {
                daolc.add(new LigneCommande(idCmd, lp.getArticle().getIdArticle(), lp.getQuantite()));
            }

            
            p.vider();
            
            response.sendRedirect("mescommandes.jsp");

        } catch (Exception e)
        {
            e.printStackTrace();
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
