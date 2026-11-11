import java.io.*; 
import java.util.*; 

public class Customer extends User { 
	 
	private CheckingAccount checking; 
	private SavingsAccount savings; 

	public static void main(String[] args) { 
		Customer customer = new Customer();
	       if (customer.login()) { 
	       	System.out.println("Login Successful"); 
 		customer.start();
	       }	
	       else { 
       			System.out.println("Login Failed"); 
	       } 

	} 
	public Customer() { 
		checking = new CheckingAccount(); 
		savings = new SavingsAccount(); 

		setUserName("Alice"); 
		setPIN("0000"); 
 
	} 
	public Customer(String userName, String PIN) {
		checking = new CheckingAccount(); 
		savings = new SavingsAccount(); 
		setUserName(userName); 
		setPIN(PIN);
	}
	public SavingsAccount getSavings() { 
		return savings; 
	}
	public void setCheckingBalance(double balance) { 
		checking.setBalance(balance); 

	} 
	public void setSavingsBalance(double balance) { 
		savings.setBalance(balance); 
	} 

	public String menu() {
	       Scanner input = new Scanner(System.in);        
		System.out.println();
        	System.out.println("Customer Menu");
        	System.out.println("0) Exit");
        	System.out.println("1) Manage Checking Account");
        	System.out.println("2) Manage Savings Account");
        	System.out.println("3) Change PIN");
        	System.out.print("Action (0-3): ");

        	return input.next();
	} 

	public void start() { 
		String choice = ""; 
		while (!choice.equals("0")) { 
			choice = menu(); 

			if (choice.equals("1")) { 
				System.out.println("Checking Account"); 
				checking.start(); 
			} 
			else if (choice.equals("2")) { 
				System.out.println("Savings Account"); 
				savings.start(); 
			} 
			else if (choice.equals("3")) { 
				changePIN(); 
			} 
			else if (choice.equals("0")) { 
				System.out.println("Have a great day"); 
			} 
			else { 
				System.out.println("Invalid choice"); 
			} 
		} 
	} 

	public void changePIN() {
	       Scanner input = new Scanner(System.in); 	       
		System.out.print("Enter new PIN: "); 
		String newPIN = input.next(); 
		setPIN(newPIN); 
		System.out.println("PIN Changed Sucessfully"); 
	} 

	public String getReport() { 
		String report = "User: " + getUserName(); 
		report = report + ", Checking: " + checking.getBalanceString(); 
		report = report + ", Savings: " + savings.getBalanceString(); 

		return report; 
	} 
} 
