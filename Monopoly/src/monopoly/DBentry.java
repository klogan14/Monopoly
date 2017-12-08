package monopoly;
/*
 * Program: CS485_lab4
 * Purpose: The program is designed to illustrate 1) the use of SQL connector 
 * to connect to and update on MySQL database; 2) the use of JSP to create a
 * Web page for data entry. To make the program work, both JDK, Apache, MySQL
 * need to be installed.
 * @copyright the program is intended for class use, it should not be distributed
 * outside the class without permission from the instructor, Dr. Mingrui Zhang  
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DBentry 
{

	private static final long serialVersionUID = 1L;
	static DBentry instance = new DBentry();
	Connection dbconn;
	ResultSet results = null;
	PreparedStatement sql;
	String dpwd = null;
	StringBuilder sb = new StringBuilder();
	
	//change URL to your database server as needed
	//String dbPath="jdbc:mysql://localhost:3306";
        String dbPath="jdbc:sqlite:C:\\Users\\John\\Monopoly\\Monopoly\\Players";     //For John's pc
	
	public static DBentry getInstance() 
	{
		if (instance==null) 
		{
			instance = new DBentry();
		}
		return instance;
	}
	
	//Establish connection to MySQL server
	public Connection newConnection() 
	{
		try 
		{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Class.forName("org.sqlite.JDBC");   //running on John's pc
			try 
			{			
				//dbconn = DriverManager.getConnection(dbPath,"root","password");
                                dbconn = DriverManager.getConnection(dbPath);  //running on John's pc
				//System.out.println("gain the connection");
				return dbconn;
			}
			catch (Exception s)
			{
				System.out.println(s.getStackTrace().toString());
			}
		}
		catch (Exception err)
		{
			System.out.println(err.getStackTrace().toString());
		}
		return null;
	}
	
	public ResultSet selectStatement( String query ) 
	{
		try 
		{

			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement(query);
			//ResultSet results;
			results=sql.executeQuery();
			//System.out.println("query="+query);
	
			dbconn.close();
			return results;
		}
		catch (Exception err) 
		{
			System.out.println(err.getMessage());
			return null;
		}
	}

	public boolean DBentry(String query) 
	{
		try {
			//System.out.println("query="+query);
			instance.newConnection();
			sql=dbconn.prepareStatement(query);
			sql.executeUpdate(query);
			dbconn.close();
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean update( String piece, int location, int playerTurn, int round) 
        {	
		try 
		{
//                        instance.DBentry( "INSERT INTO MonopolyDB.MonopolyGame (`Piece`, `Location`, `PlayerTurn`, `Round`)"    
//                         +"VALUES ( '"+piece+"' ,'"+location+"' ,'"+playerTurn+"' ,'"+round+"');");
                        
                        instance.DBentry( "INSERT INTO Players.game1 (`Piece`, `Location`, `PlayerTurn`, `Round`)"    //John's pc
                         +"VALUES ( '"+piece+"' ,'"+location+"' ,'"+playerTurn+"' ,'"+round+"');");
//				
			return true;
		}
		catch ( Exception err ) 
		{
			err.getStackTrace();
			return false;
		}
	}

}