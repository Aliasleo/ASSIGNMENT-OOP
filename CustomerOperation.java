import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomerOperation extends Customer {
    private static CustomerOperation instance = null;

    private CustomerOperation(){}
    public static CustomerOperation getInstance(){
        if (instance == null){
            instance = new CustomerOperation();
        }
        return instance;
    }
    
    public boolean registerCustomer( String userName, String password, String email, String mobile){
        if (!validateEmail(email)|| !validateMobile(mobile)) return false; // kiểm tra email và sdt

        UserOperation operation = UserOperation.getInstance();
        // You may want to add more logic here to actually register the customer
        // For now, return true to indicate success
        return true;
    }

    public boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }

    public boolean validateMobile(String mobile) {
        return mobile != null && mobile.matches("\\d{10}");
    }

}
