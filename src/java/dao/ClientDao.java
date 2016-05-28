/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Walid
 */
public class ClientDao
{

    Connection con = DBConnexion.getInstance();

    public boolean add(Client a)
    {
        try
        {
            String req = "INSERT INTO `wshopdb`.`client` (`login`, `mdp`, `nom`, `prenom`, `dtnaissance`)"
                    + " VALUES ('" + a.getLogin() + "', '" + a.getMdp() + "', '" + a.getNom() + "', '" + a.getPrenom() + "', '" + a.getDtNaissance() + "');";

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

    public boolean remove(String login)
    {
        try
        {
            String req = "DELETE FROM client " + "WHERE login = " + login;

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

    public boolean update(Client a)
    {
        try
        {
            String req = "UPDATE `wshopdb`.`client` "
                    + "SET `mdp`='" + a.getMdp() + "', "
                    + "`nom`='" + a.getNom() + "', "
                    + "`prenom`='" + a.getPrenom() + "' "
                    + "WHERE `login`='" + a.getLogin() + "';";

            System.out.println(req);

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

    public Client findByAuthentification(String log, String pass)
    {
        String req = "SELECT* " + " FROM client " + " WHERE login = '" + log + "' AND mdp = '" + pass + "';";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Client e = null;

            if (rs.next())
            {
                //public Client(String login, String mdp, String nom, String prenom, Date dtNaissance)

                e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));

            }
            return e;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Vector<Client> findAll()
    {
        String req = "SELECT* " + " FROM client ";

        Vector<Client> vect = null;

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

                Client e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));

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

    public boolean bloquer(String login)
    {
        try
        {
            String req = "UPDATE client SET "
                    + "etat=0"
                    + " WHERE login='" + login + "';";

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

    public boolean modifier(Client a)
    {
        try
        {
            String req = "UPDATE `wshopdb`.`client` SET "
                    + "`mdp`='" + a.getMdp() + "', "
                    + "`nom`='" + a.getNom() + "', "
                    + "`prenom`='" + a.getPrenom() + "', "
                    + "`dtnaissance`='" + a.getDtNaissance() + "', "
                    + "`etat`=" + a.getEtat() + "  "
                    + "WHERE `login`='" + a.getLogin() + "';";

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

    
    
        public Client findByLogin(String log)
    {
        String req = "SELECT* " + " FROM client " + " WHERE login = '" + log + "';";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Client e = null;

            if (rs.next())
            {
                //public Client(String login, String mdp, String nom, String prenom, Date dtNaissance)
                
                e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                
            }
            return e;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
}
