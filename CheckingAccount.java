import java.io.*; 
import java.util.*; 
 
public class CheckingAccount implements HasMenu, Serializable {
 
	private double balance;

	public static void main(String[] args) { 
		CheckingAccount account = new CheckingAccount(); 
		account.start(); 
	}
	public CheckingAccount() { 
		balance = 0; 
	}

	public CheckingAccount(double balance) { 
		this.balance = balance; 
	} 
	public double getBalance() { 
		return balance; 
	} 
	public String getBalanceString() { 
		return String.format("$%.2f", balance); 
	}

      	public void  setBalance(double balance) {
		this.balance = balance; 
	}

	public void checkBalance() { 
		System.out.println("Current balance: " + getBalanceString()); 
	} 

	private double getDouble() {
	        Scanner input = new Scanner(System.in);	
		return input.nextDouble(); 
	} 
	public void makeDeposit() {  
		System.out.print("How much to deposit? "); 
		double amount = getDouble(); 
		if (amount > 0) { 
			balance = balance + amount; 
			System.out.println("Deposit Successful"); 
		} 
		else { 
			System.out.println("Invalid Amount" ); 
		} 
		checkBalance();  
	}

	public void makeWithdrawal() {
		
		System.out.print("How much to withdrawal? "); 
		double amount = getDouble(); 
		if (amount > 0 && amount <= balance) { 
		balance = balance - amount;
		System.out.println("Withdrawal Successful"); 

       		}
        	else {
            		System.out.println("Invalid amount or not enough money");
        }

        System.out.println("new Balance: " + getBalanceString());
    }

    public String menu() {
	Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Account menu");
        System.out.println("0) quit");
        System.out.println("1) check balance");
        System.out.println("2) make a deposit");
        System.out.println("3) make a withdrawal");
        System.out.print("Please enter 0-3: ");

        return input.next();
    }
     public void start() {
        String choice = "";

        while (!choice.equals("0")) {
            choice = menu();

            if (choice.equals("1")) {
                checkBalance();
            }
            else if (choice.equals("2")) {
                makeDeposit();
            }
            else if (choice.equals("3")) {
                makeWithdrawal();
            }
            else if (!choice.equals("0")) {
                System.out.println("Invalid choice");
            }
        }
    }
}

