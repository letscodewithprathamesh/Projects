package test;

import java.sql.*;

public class DBConnection 
{
	private static Connection con=null; // why we are declaring con object reference as private because it should only access through method....static because it will get the memory at the time of class creation
	
	private DBConnection()
	{
		
	}
	//we created a private constructor because ,there will be no object creation for this Class. We are declaring everything as static therefore we dont need create object for calling method we can access it with class name
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(DBInfo.dbUrl,DBInfo.uName,DBInfo.pWord);
			//DBInfo.dbUrl,DBInfo.uName,DBInfo.pWord all the variable are static , and for accessing static we need Class or Interface name
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//static block run on its own we dont need to call it,as soon as static variable created , static block will run and connection object will be created and stored in con reference
	
	public static Connection getCon()
	{
		return con;
	}
	
	//we creating this method because we are creating the connection object an passing it through getCon() ,getCon() is user defined method for accessing connection object.method is static and public therefore we can access using classname and throughout the package
	//this method declare with return type as Connection . we had created static variable with that return type only therefore we directly giving connection object reference
	
	
	
	
	
}
