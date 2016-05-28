/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Commande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Walid
 */
public class CommandeDao
{

    Connection con = DBConnexion.getInstance();

    public boolean add(Commande a)
    {
        try
        {
            String req = "INSERT INTO `wshopdb`.`commande` (`login`, `prixtotale`) "
                    + "VALUES ('"+a.getLogin()+"', '"+a.getPrixTotale()+"');";

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

    public boolean remove(int idCmd)
    {
        try
        {
            String req = "DELETE FROM commande " + "WHERE idcommande = " + idCmd;

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            e1.printStackTrace();
        }

        return false;
    }

    public boolean validerCommande(int idCommande)
    {
        try
        {
            String req = "UPDATE `wshopdb`.`commande` SET "
                    + "`etat`='1' "
                    + "WHERE `idcommande`='"+idCommande+"';";

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

     public boolean refuserCommande(int idCommande)
    {
        try
        {
            String req = "UPDATE `wshopdb`.`commande` SET "
                    + "`etat`='2' "
                    + "WHERE `idcommande`='"+idCommande+"';";

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

     
    public Vector<Commande> findByLogin(String login)
    {
        String req = "SELECT* " + " FROM commande WHERE login = '" +login+"';";

        Vector<Commande> vect = null;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next())
            {

                if (vect == null)
                {
                    vect = new Vector<>();
                }

                Commande e = new Commande(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

                vect.add(e);
            }

            return vect;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    
    public Vector<Commande> findAll()
    {
        String req = "SELECT* " + " FROM commande ";

        Vector<Commande> vect = null;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next())
            {

                if (vect == null)
                {
                    vect = new Vector<>();
                }

                Commande e = new Commande(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

                vect.add(e);
            }

            return vect;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


    
    public int getLastID()
    {
        String req = "SELECT max(idcommande) FROM commande ";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            if (rs.next())
            {
                return rs.getInt(1);
            }

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return -1;
    }

    
    public Vector<Commande> findEnAttente()
    {
        String req = "SELECT* " + " FROM commande where etat=0";

        Vector<Commande> vect = null;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next())
            {

                if (vect == null)
                {
                    vect = new Vector<>();
                }

                Commande e = new Commande(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

                vect.add(e);
            }

            return vect;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    
    
    
}
