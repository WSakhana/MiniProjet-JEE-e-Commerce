package dao ;


import java.sql.*;

import com.mysql.jdbc.Connection;

public class DBConnexion 
{
    private static Connection con=null;
 
    private DBConnexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/wshopdb","root","dilaww88");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    public static Connection getInstance()
    {
        if(con==null)
            new DBConnexion();
        return con;
            
        
    }
}