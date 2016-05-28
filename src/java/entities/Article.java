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
public class Article
{
    private int idArticle ;
    private String libelle ;
    private String desc ;
    private double prix ; 
    private String img ;
    private int qte ;
    private Date dateAjout ;

    public Article()
    {
    }


    
    
    public Article(String libelle, String desc, double prix, String img, int qte)
    {
        this.libelle = libelle;
        this.desc = desc;
        this.prix = prix;
        this.img = img;
        this.qte = qte;
    }

    
    
    
    public Article(int idArticle, String libelle, String desc, double prix, String img, int qte, Date dateAjout)
    {
        this.idArticle = idArticle;
        this.libelle = libelle;
        this.desc = desc;
        this.prix = prix;
        this.img = img;
        this.qte = qte;
        this.dateAjout = dateAjout;
    }

    
    
    public int getIdArticle()
    {
        return idArticle;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public String getDesc()
    {
        return desc;
    }

    public double getPrix()
    {
        return prix;
    }

    public String getImg()
    {
        return img;
    }

    public int getQte()
    {
        return qte;
    }

    public Date getDateAjout()
    {
        return dateAjout;
    }

    public void setIdArticle(int idArticle)
    {
        this.idArticle = idArticle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setPrix(double prix)
    {
        this.prix = prix;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public void setQte(int qte)
    {
        this.qte = qte;
    }

    public void setDateAjout(Date dateAjout)
    {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString()
    {
        return "Article{" + "idArticle=" + idArticle + ", libelle=" + libelle + ", desc=" + desc + ", prix=" + prix + ", img=" + img + ", qte=" + qte + ", dateAjout=" + dateAjout + '}';
    }
    
    
    
}
