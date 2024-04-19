package atm;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Account
{
	private int customerNumber;
	private int pinNumber;     
	private double checkingBalance; // double as we can take value in decimal 
	private double savingBalance; // Every decimal value in java by default is double
	
	Scanner input =new Scanner(System.in);  // input is just identifer(sc)
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

	public int getCustomerNumber()
	{
		return customerNumber;
	}
	
	public void setCustomerNumber(int customerNumber)
	{
		this.customerNumber=customerNumber;
		
	}

	public int getPinNumber()
	{
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) 
	{
		this.pinNumber = pinNumber;
		
	}

	public double getCheckBalance()  // only writing this method will return the checkbalance  
	{
		return checkingBalance;
	}

	public double getSavingBalance() 
	{
		return savingBalance;
	}

	public double calCheckingWithdraw(double amount) // this is none other than setter() for checkingBalance 
	{
		checkingBalance = (checkingBalance-amount);
		return checkingBalance;
	}
	
	public double calSavingWithdraw(double amount)// this is none other than setter() for checkingBalance
	{
		savingBalance=(savingBalance - amount);
		return savingBalance;
	}
	
	public double calCheckingDeposit(double amount)// this is none other than setter() for savingBalance
	{
		checkingBalance=(checkingBalance+amount);
		return checkingBalance;
	}
	
	public double calSavingDeposit(double amount)// this is none other than setter() for savingBalance
	{
		savingBalance=(savingBalance+amount);
		return savingBalance;
	}
	
	public void getCheckingWithdrawInput()
	{
		System.out.println("Checking account Balance"+moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to Withdraw from Checking Account: ");
		
		double amount=input.nextDouble(); // accepting double value
	
		if((checkingBalance-amount)>=0)
		{
			this.calCheckingWithdraw(amount); // we can directly also call the method because by default this keyword is applied on method
			System.out.println("New Checking Account Balance "+moneyFormat.format(checkingBalance));
		}
		else
		{
			System.out.println("Balance cannot be Negative");
		}	
	
	}
	
	public void getSavingWithdrawInput()
	{
		System.out.println("Saving account Balance"+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to Withdraw from Saving Account: ");
		
		double amount=input.nextDouble();
	
		if((savingBalance-amount)>=0)
		{
			this.calSavingWithdraw(amount); // we can directly also call the method because by default this keyword is applied on method
			System.out.println("New Saving Account Balance "+moneyFormat.format(savingBalance));
		}
		else
		{
			System.out.println("Balance cannot be Negative");
		}	
	}
	
	public void getCheckingDepositInput()
	{
		System.out.println("Checking account Balance"+moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to Deposit from Checking Account: ");
		
		double amount=input.nextDouble();
	
		if((checkingBalance+amount)>=0)
		{
			this.calCheckingDeposit(amount); // we can directly also call the method because by default this keyword is applied on method
			System.out.println("New Checking Account Balance "+moneyFormat.format(checkingBalance));
		}
		else
		{
			System.out.println("Balance cannot be Negative");
		}	
	
	}
	
	public void getSavingDepositInput()
	{
		System.out.println("Saving account Balance"+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to Deposit from Saving Account: ");
		
		double amount=input.nextDouble();
	
		if((savingBalance+amount)>=0)
		{
			this.calSavingDeposit(amount); // we can directly also call the method because by default this keyword is applied on method
			System.out.println("New Saving Account Balance "+moneyFormat.format(savingBalance));
		}
		else
		{
			System.out.println("Balance cannot be Negative");
		}	
	}
	
	
	
}
