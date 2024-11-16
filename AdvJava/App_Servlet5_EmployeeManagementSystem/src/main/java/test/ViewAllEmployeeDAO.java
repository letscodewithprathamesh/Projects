package test;

import java.sql.*;
import java.util.*;
public class ViewAllEmployeeDAO 
{
	public ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
	
	public ArrayList<EmployeeBean> retrieve()
	{
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("select * from employee59");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				EmployeeBean eb=new EmployeeBean();
				
				eb.seteId(rs.getString(1));
				eb.seteName(rs.getString(2));
				eb.seteDesg(rs.getString(3));
				eb.setbSal(rs.getInt(4));
				eb.setHra(rs.getFloat(5));
				eb.setDa(rs.getFloat(6));
				eb.setTotSal(rs.getFloat(7));
				
				al.add(eb); //adding all data from bean object to arraylist object ... arraylist contains the data , one particular field(database) as one single Object....like that how many fields are there that many object are placed into it
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
	

}
