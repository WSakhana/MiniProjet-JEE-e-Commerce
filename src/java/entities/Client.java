/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Walid
 */
public class Client
{
  private String login ;
  private String mdp ;
  private String nom ;
  private String prenom ;
  private Date dtNaissance;
  private int etat;

    public Client()
    {
    }

  
  
    
    public Client(String login, String mdp, String nom, String prenom, Date dtNaissance)
    {
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dtNaissance = dtNaissance;
    }

    
          public Client(String login, String mdp, String nom, String prenom, Date dtNaissance,int etat)
    {
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dtNaissance = dtNaissance;
        this.etat=etat;
    }

          
    public int getEtat()
    {
        return etat;
    }

    public void setEtat(int etat)
    {
        this.etat = etat;
    }

    
    
    public String getLogin()
    {
        return login;
    }

    public String getMdp()
    {
        return mdp;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public Date getDtNaissance()
    {
        return dtNaissance;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public void setDtNaissance(Date dtNaissance)
    {
        this.dtNaissance = dtNaissance;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.login);
        hash = 83 * hash + Objects.hashCode(this.mdp);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.login, other.login))
        {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Client{" + "login=" + login + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + ", dtNaissance=" + dtNaissance + '}';
    }
  
    
    
}
