package test;

public interface DBInfo 
{
	public static final String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	
	public static final String uName="testdb";
	
	public static final String pWord="1234";
	
	//static access using interface name and final because it should not change and remain constant throughout the program 
	//in a interface because no need to create object for it...We can instantiate in Interface
}
