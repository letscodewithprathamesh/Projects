package project;

public class Employee
{

	private int empno;
	private String ename;
	private int salaray;
	
	
	public int getEmpno() {
		return empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public int getSalaray() {
		return salaray;
	}
	
	public Employee(int empno,String ename,int salaray)
	{
		this.empno = empno;
		this.ename= ename;
		this.salaray=salaray;
	}
	
	@Override
	public String toString()
	{
		
		return empno+" "+ename+" "+salaray;
	}
	
	
	
	
	
	
}
