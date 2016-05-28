/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import dao.ArticleDao;
import dao.ClientDao;
import entities.Client;

/**
 *
 * @author Walid
 */
public class TestMain 
{
    public static void main(String[] args) 
    {
        ArticleDao dao = new ArticleDao();
        ClientDao daoC = new ClientDao();
        
        for (Client client : daoC.findAll())
        {
            System.out.println(client);
        }
        
        System.out.println(dao.findByID(1));
        
        System.out.println("#END#");
    }
}
