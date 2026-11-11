import java.io.*;
import java.util.*;

public abstract class User implements HasMenu, Serializable {

    private String userName;
    private String PIN;

    public User() {
        userName = "";
        PIN = "";
    }

    public boolean login() {
        Scanner input = new Scanner(System.in);

        System.out.print("User name: ");
        String name = input.next();

        System.out.print("PIN: ");
        String pin = input.next();

        return login(name, pin);
    }

    public boolean login(String userName, String PIN) {
        if (this.userName.equals(userName) &&
            this.PIN.equals(PIN)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public abstract String getReport();
}
