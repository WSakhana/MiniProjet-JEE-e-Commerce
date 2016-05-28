/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Walid
 */
public class LigneCommande
{
private int idCommande ;
private int idArticle ;
private int nbr;

    public LigneCommande(int idCommande, int idArticle, int nbr)
    {
        this.idCommande = idCommande;
        this.idArticle = idArticle;
        this.nbr = nbr;
    }

    public int getIdCommande()
    {
        return idCommande;
    }

    public int getIdArticle()
    {
        return idArticle;
    }

    public int getNbr()
    {
        return nbr;
    }

    public void setIdCommande(int idCommande)
    {
        this.idCommande = idCommande;
    }

    public void setIdArticle(int idArticle)
    {
        this.idArticle = idArticle;
    }

    public void setNbr(int nbr)
    {
        this.nbr = nbr;
    }


    
}
