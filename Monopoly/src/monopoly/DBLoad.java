/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBLoad implements LoadGame
{

    @Override
    public List loadGame(String filename) {
        List players = new ArrayList();
        String url = "jdbc:sqlite:C:\\Users\\John\\Monopoly\\Monopoly\\Players"; // database location
        String url2="jdbc:mysql://localhost:3306";
        Connection conn = null;
        java.sql.Statement stmt = null; 
        String query = "select *  from " + filename;
        
        try {
            //"com.mysql.jdbc.Driver"
            Class.forName("org.sqlite.JDBC");  
            conn = DriverManager.getConnection(url);
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBLoad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connection failed");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            Class.forName("org.sqlite.JDBC");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("cannot load driver");
        }

        try { 
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                players.add(rs.getString("Piece"));
                players.add(rs.getString("Location"));
                players.add(rs.getString("Turn"));
            }
            players.add(rs.getString("Round"));
        }
        catch(SQLException e){
            System.out.println("query didnt work");
        }
        
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBLoad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
        return players;
    }  
}
