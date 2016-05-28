package panier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Walid
 */
import entities.Article;
import java.util.ArrayList;
import java.util.Collections;

public class Panier
{

    ArrayList<LignePanier> lignesPanier;

    public Panier()
    {
        lignesPanier = new ArrayList<LignePanier>();
    }

    @Override
    public String toString()
    {
        String s = "Panier : \n";
        for (LignePanier l : lignesPanier)
        {
            s += l.toString() + "\n";
        }

        return s;

    }

    
    
    public void addArticle(Article art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdArticle() == art.getIdArticle())
            {
                lignePanier.setQuantite(lignePanier.getQuantite() + 1);
                return;
            }
        }

        lignesPanier.add(new LignePanier(art, 1));
    }

    public void sousArticle(Article art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdArticle() == art.getIdArticle())
            {
                if (lignePanier.getQuantite() > 1)
                {
                    lignePanier.setQuantite(lignePanier.getQuantite() - 1);
                } else
                {
                    lignesPanier.remove(lignePanier);
                    return ;
                }
            }
        }


    }

    public int getNumberArticle()
    {
        return lignesPanier.size();
    }

    public ArrayList<LignePanier> getLignesPanier()
    {
        return lignesPanier;
    }

    public void removeArticle(Article art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdArticle() == art.getIdArticle())
            {
                lignesPanier.remove(lignePanier);
                return ;
            }
        }

    }
    
    public void vider()
    {
        try
        {

            while (lignesPanier.get(0) != null)
            {
                lignesPanier.remove(lignesPanier.get(0));
            }

        } catch (Exception e)
        {
        }
               
    }
}
