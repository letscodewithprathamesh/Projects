package project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class EmployeeCall  
{

	void meth1()
	{
		ArrayList<Employee> al=new ArrayList<Employee>();
		
		int ch;
		
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		do
		{
			System.out.println("--------- Welcome to Employee Details ---------");
			System.out.println(" 1)  INSERT");
			System.out.println(" 2) DISPLAY ");
			System.out.println(" 3) SEARCH");
			System.out.println(" 4) DELETE");
			System.out.println(" 5) UPDATE");
			System.out.println(" 6) EXIT");
			System.out.println("Enter your choice number");
			
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				
				System.out.println("---------------------------------------------------");
				
				System.out.print("Enter Employee No ");
				int empno =sc.nextInt();
				
				System.out.print("Enter Employee Name ");
				String empname =sc1.nextLine();
				
				System.out.print("Enter Employee Salaray");
				int salaray = sc.nextInt();
				
				al.add(new Employee(empno,empname,salaray)); // passing user defined data into arraylist
				
				//System.out.println(al); 
				
				System.out.println("---------------------------------------------------");
				
				break;
				
			case 2:
				System.out.println("---------------------------------------------------");
				
				Iterator<Employee>i=al.iterator();
				
				while(i.hasNext())
				{
					Employee e=i.next();
					System.out.println(e);
				}
				
				System.out.println("---------------------------------------------------");
				break;
				
			case 3:
				boolean found=false;
				
				System.out.print("Enter Emp No ");
				empno=sc.nextInt();
				
				System.out.println("---------------------------------------------------");
				
				i =al.iterator(); 
				// here i is declared in case 2 and it is local variable , we can use throughout meth1()
				
				while(i.hasNext())
				{
					Employee e=i.next();      // but why we declare e two times because it local to loop only outside loop we cannot use it thats why we need declare
					if(empno==e.getEmpno())
					{
						System.out.println(e);
						found=true;
					}
				}
				
				if(!found)
				{
					System.out.println("Record NOT FOUND");
				}
				
				System.out.println("---------------------------------------------------");
				break;
			
			case 4:
				found=false;
				
				System.out.print("Enter Emp No ");
				empno=sc.nextInt();
				
				System.out.println("---------------------------------------------------");
				
				i =al.iterator(); 
				
				while(i.hasNext())
				{
					Employee e=i.next();     
					if(empno==e.getEmpno())
					{
						i.remove();
						found=true;
					}
				}
				
				if(!found)
				{
					System.out.println("Record NOT FOUND");
				}
				else
				{
					System.out.println("Deleted Successfully ");
				}
				
				System.out.println("---------------------------------------------------");
				break;
			
			case 5:
				found=false;
				
				System.out.print("Enter Emp No ");
				empno=sc.nextInt();
				
				System.out.println("---------------------------------------------------");
				
				ListIterator<Employee>li =al.listIterator(); 
				// here i is declared in case 2 and it is local variable , we can use throughout meth1()
				
				while(li.hasNext())
				{
					Employee e=li.next();      // but why we declare e two times because it local to loop only outside loop we cannot use it thats why we need declare
					if(empno==e.getEmpno())
					{
						System.out.println("Enter new Name");
						empname=sc1.nextLine();
						
						System.out.println("Enter new Salaray");
						salaray=sc.nextInt();
						
						li.set(new Employee(empno,empname,salaray));
						found=true;
					}
				}
				
				if(!found)
				{
					System.out.println("Record NOT FOUND");
				}
				else
				{
					System.out.println("Updated Successfully ");
				}
				
				System.out.println("---------------------------------------------------");
				break;
			case 6:
				System.out.println("Thank you for using App, Bye");
				break;
				
			default:
				System.out.println("Invalid Input.... Please Press key between 1 to 6");
			
			}
			
		}
		while(ch!=6);
	
		sc.close();
		sc1.close();
	}
	
	
	
	
	public static void main(String[] args)
	{
		new EmployeeCall().meth1();
		
	}
	
}
