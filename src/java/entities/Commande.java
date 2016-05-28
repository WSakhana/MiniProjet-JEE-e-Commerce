/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Walid
 */
public class Commande
{
    private int idCommande ;
    private String login ;
    private Date dateCmd ;
    private double prixTotale ;
    private int etat ;

    public Commande(int idCommande, String login, Date dateCmd, double prixTotale, int etat)
    {
        this.idCommande = idCommande;
        this.login = login;
        this.dateCmd = dateCmd;
        this.prixTotale = prixTotale;
        this.etat = etat;
    }

    public Commande(String login, double prixTotale)
    {
        this.login = login;
        this.dateCmd = dateCmd;
        this.prixTotale = prixTotale;
        this.etat = etat;
    }

    
    
    public int getIdCommande()
    {
        return idCommande;
    }

    public String getLogin()
    {
        return login;
    }

    public Date getDateCmd()
    {
        return dateCmd;
    }

    public double getPrixTotale()
    {
        return prixTotale;
    }

    public int getEtat()
    {
        return etat;
    }

    public void setIdCommande(int idCommande)
    {
        this.idCommande = idCommande;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setDateCmd(Date dateCmd)
    {
        this.dateCmd = dateCmd;
    }

    public void setPrixTotale(double prixTotale)
    {
        this.prixTotale = prixTotale;
    }

    public void setEtat(int etat)
    {
        this.etat = etat;
    }
    
    
    
    
}
