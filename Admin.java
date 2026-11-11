import java.io.*; 
import java.util.*; 

public class Admin extends User {
       public Admin() { 
	setUserName("admin"); 
	setPIN("0000"); 
} 

public String menu() { 
	Scanner input = new Scanner(System.in); 
	System.out.println(); 
	System.out.println("Admin Menu"); 
	System.out.println("0) Exit this menu");
	System.out.println("1) Full customer report");
	System.out.println("2) Add user");
	System.out.println("3) Apply interest to savings accounts");
	System.out.println("Action; ");

	return input.next(); 

    } 
    public void start() { 

    } 
	
    public String getReport() { 
	    return "Admin: " + getUserName(); 
    } 
} 
