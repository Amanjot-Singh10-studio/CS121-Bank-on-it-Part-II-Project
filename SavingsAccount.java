import java.io.*; 
import java.util.*; 

public class SavingsAccount extends CheckingAccount { 
	private double interestRate; 
	public SavingsAccount() { 
		interestRate = 0; 
	} 
	public static void main(String[] args) { 
		SavingsAccount account = new SavingsAccount(); 
		account.start(); 
	} 
	public void calcInterest() { 
		double interest = getBalance() * interestRate; 
		setBalance(getBalance() + interest); 
	} 
	public void setInterestRate(double interestRate) { 
		this.interestRate = interestRate; 
	} 
	public double getInterestRate() { 
		return interestRate; 
	} 
}

