package atm;

import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OptionMenu extends Account
{
	Scanner menuInput=new Scanner(System.in);
	
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

	HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
	
	public void getLogin() throws IOException
	{
		int x=1;
		
		do 
		{
			try 
			{
				data.put(952141,191904);
				data.put(989947,71976);
				
				//System.out.println(data);
				
				System.out.println("Welcome to ATM ");
				System.out.println("Enter Customer Number ");
				this.setCustomerNumber(menuInput.nextInt());
				System.out.println("Enter Pin Number ");
				this.setPinNumber(menuInput.nextInt());
				
			}
			catch(Exception e)
			{
				System.out.println("\n"+"Invalid Character(s) . Only Number"+"\n");
				x=2;
				
			}
			
			/*
			the value given by the user stored in customerNumber 
			using getter() and return using setter()
			*/
			
			int cn = this.getCustomerNumber();
			
	        int pn = this.getPinNumber();	
				
			/*
			cn call get() which return value from variable 
			containKey() is method of hashmap it will give true or false
			if particular value given by user matches with the key present in hashmap
			
			get() will give the Value pair for that given key-value pair present in hashmap
			
			*/
			
			
			if(data.containsKey(cn) && data.get(cn)==pn)
			{
				this.getAccountType();
			}
			else
			{
				System.out.println("\n"+"Wrong Customer Number or Pin Number"+"\n");
			}
			
			
		}
		while(x==1);
	}
	
	public void getAccountType()
	{
		System.out.println("Selecting the Account you want to Access");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");

		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		
		case 1:
				this.getChecking();
				break;
				
		case 2:
				this.getSaving();
				break;
				
		case 3:
				System.out.println("Thank You for using our ATM , Bye \n ");
				break;
				
		default:
				System.out.println("\n"+"Invalid Choice"+"\n");
				this.getAccountType();
		}
	}
	
	public void getChecking()
	{
		System.out.println("Checking Account");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice : ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			System.out.println("Checking Account Balance"+moneyFormat.format(getCheckBalance()));
			this.getAccountType();
			break;
			
		case 2:
			this.getCheckingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for banking with us,Bye ");
			break;
			
		default:
			System.out.println("\n"+"Invalid choice"+"\n");
			this.getChecking();
		
		}
	}
	
	public void getSaving()
	{
		System.out.println("Saving Account");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice : ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			System.out.println("Saving Account Balance"+moneyFormat.format(getSavingBalance()));
			this.getAccountType();
			break;
			
		case 2:
			this.getSavingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for banking with us,Bye ");
			break;
			
		default:
			System.out.println("\n"+"Invalid choice"+"\n");
			this.getSaving();
		
		}
	}
	
	
	
}
