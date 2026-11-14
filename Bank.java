import java.io.*;
import java.util.*;

class CustomerList extends ArrayList<Customer> {
}

public class Bank implements HasMenu {

    private Admin admin;
    private CustomerList customers;

    public static void main(String[] args) {
        new Bank();
    }

    public Bank() {
        admin = new Admin();
        customers = new CustomerList();

        // Uncomment these lines only when resetting customer data
        // this.loadSampleCustomers();
        // this.saveCustomers();

        this.loadCustomers();
        this.start();
        this.saveCustomers();
    }

    public String menu() {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Bank Menu");
        System.out.println("0) Exit system");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.print("Action: ");

        return input.next();
    }

    public void start() {
        boolean keepGoing = true;

        while (keepGoing) {
            String choice = menu();

            if (choice.equals("1")) {
                System.out.println("Admin Login");

                if (admin.login() == true) {
                    System.out.println("Login Successful");
                    startAdmin();
                }
                else {
                    System.out.println("Invalid Login");
                }
            }
            else if (choice.equals("2")) {
                loginAsCustomer();
            }
            else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                keepGoing = false;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }

    public void startAdmin() {
        boolean keepGoing = true;

        while (keepGoing) {
            String choice = admin.menu();

            if (choice.equals("1")) {
                fullCustomerReport();
            }
            else if (choice.equals("2")) {
                addUser();
            }
            else if (choice.equals("3")) {
                applyInterest();
            }
            else if (choice.equals("0")) {
                keepGoing = false;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }

    public void fullCustomerReport() {
        System.out.println("Full customer report");

        for (Customer customer : customers) {
            System.out.println(customer.getReport());
        }
    }

    public void addUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("Add User");

        System.out.print("Name: ");
        String name = input.next();

        System.out.print("PIN: ");
        String pin = input.next();

        Customer customer = new Customer(name, pin);

        customer.getSavings().setInterestRate(0.05);

        customers.add(customer);

        System.out.println("Customer added");
    }

    public void applyInterest() {
        System.out.println("Apply interest");

        for (Customer customer : customers) {
            customer.getSavings().calcInterest();
        }

        System.out.println("Interest applied");
    }

    public void loginAsCustomer() {
        Scanner input = new Scanner(System.in);

        System.out.print("User name: ");
        String name = input.next();

        System.out.print("PIN: ");
        String pin = input.next();

        boolean found = false;

        for (Customer customer : customers) {

            if (customer.login(name, pin) == true) {
                found = true;

                System.out.println("Login Successful");
                customer.start();
                break;
            }
        }

        if (found == false) {
            System.out.println("Invalid Login");
        }
    }

    public void loadSampleCustomers() {
        Customer alice = new Customer("Alice", "0000");

        alice.setCheckingBalance(1000);
        alice.setSavingsBalance(1000);
        alice.getSavings().setInterestRate(0.05);

        Customer bob = new Customer("Bob", "1111");
        bob.getSavings().setInterestRate(0.05);

        Customer cindy = new Customer("Cindy", "2222");
        cindy.getSavings().setInterestRate(0.05);

        customers.add(alice);
        customers.add(bob);
        customers.add(cindy);
    }

    public void saveCustomers() {
        try {
            ObjectOutputStream output =
                new ObjectOutputStream(
                    new FileOutputStream("customers.dat"));

            output.writeObject(customers);
            output.close();

            System.out.println("Customers saved");
        }
        catch (IOException e) {
            System.out.println("Error saving customers");
        }
    }

    public void loadCustomers() {
        File file = new File("customers.dat");

        if (file.exists()) {
            try {
                ObjectInputStream input =
                    new ObjectInputStream(
                        new FileInputStream("customers.dat"));

                customers = (CustomerList) input.readObject();
                input.close();

                System.out.println("Customers loaded");
            }
            catch (Exception e) {
                System.out.println("Error loading customers");
                System.out.println("Please check your saved data file.");
                System.exit(1);
            }
        }
        else {
            loadSampleCustomers();
        }
    }
}

