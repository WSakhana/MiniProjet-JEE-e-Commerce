
<%@page import="entities.LigneCommande"%>
<%@page import="dao.LigneCommandeDao"%>
<%@page import="dao.CommandeDao"%>
<%@page import="entities.Commande"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="entities.Article"%>
<%@page import="java.util.Vector"%>
<%@page import="dao.ArticleDao"%>
<%@include file="header.jsp" %>

<%    Client client = (Client) request.getSession().getAttribute("client");


    
    if (client == null)
    {
        response.sendRedirect("index.jsp?con");
        return;
    }
    
    Vector<Commande> cmd = (new CommandeDao()).findByLogin(client.getLogin());    
    
    if(cmd == null)
        cmd = new Vector<Commande>();
    

%>


<div class="RightSide">
    <div class="bredCrum">
        <h4><a href="index.html">Accueil</a>   >>  <a href="#" class="select"> Mes Commandes   </a> </h4>
    </div>    



    <table  style="border-style:solid  ;width: 100%; text-align: center">
        
        <%
            for(Commande c : cmd)
            {
                String etat = "En Attente";
                if(c.getEtat() == 1)
                    etat = "Valide";
                if(c.getEtat() == 2)
                    etat = "Refuse";
                
        %>
        <tr style="text-align: left">
            <td colspan="2" style="background-color: #E6E6E6; font-size: larger; color: #000000">
                <b>Commande Numero : </b><%= c.getIdCommande() %> <b> cree le </b><%= c.getDateCmd() %>  
            </td>
        
            <td colspan="1" style="background-color: #E6E6E6; font-size: larger; color: #000000; color: green">
                <center><b>(<%= etat %>)</b></center>
            </td>
            
            <%--
            <td style="background-color: #E6E6E6; font-size: larger; color: #000000">
                <center><a href="#">
                    <img src="images/no.png" width="30">
                </a></center>
            </td>
            --%>
        
        </tr>
        
        <% 
        
            LigneCommandeDao daolc = new LigneCommandeDao();
            Vector<LigneCommande> lc = daolc.findAll(c.getIdCommande());
            
            for(LigneCommande l : lc){
                Article a = (new ArticleDao()).findByID(l.getIdArticle());
        
        %>
        
        <tr>
            <td>
                <%= a.getLibelle() %>
            </td>
            <td>
                <%= a.getPrix()%> $
            </td>
            <td>
                <%= l.getNbr() %>
            </td>
            
            
        </tr>
        <% } %>
        
        <tr>
            <td colspan="5" style="text-align: right; padding-right: 20px; font-size: 20px;border-style: dashed; border-width: 1px">
               Prix Totale : <%= c.getPrixTotale() %>
            </td>
            
        </tr>
        
        <% } %>
    </table>    


</div>



<%@include file="footer.jsp" %>