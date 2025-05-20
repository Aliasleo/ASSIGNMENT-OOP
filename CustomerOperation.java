import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomerOperation {
    private static CustomerOperation instance = null;

    private CustomerOperation(){}
    public static CustomerOperation getInstance(){
        if (instance == null){
            instance = new CustomerOperation();
        }
        return instance;
    }
    public boolean checkUsernameExist(String userName) {
        try (Scanner scanner = new Scanner(new File("data/users.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Tìm "user_name":"abc" trong dòng hiện tại
                if (line.contains("\"user_name\":\"" + userName + "\"")) {
                    return true; // Nếu tìm thấy, trả về true
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file data/users.txt");
        }
        return false; // Nếu không tìm thấy
    }

    public boolean registerCustomer( String userName, String password, String email, String mobile){
        if (!validateEmail(email)|| !validateMobile(mobile)) return false; // kiểm tra email và sdt

        UserOperation oup
    }

}
