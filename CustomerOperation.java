package Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import ModelClass.Customer;

public class CustomerOperation extends UserOperation {
    private static CustomerOperation instance = null;

    private CustomerOperation() {}

    public static CustomerOperation getInstance() {
        if (instance == null) {
            instance = new CustomerOperation();
        }
        return instance;
    }

    public boolean checkUsernameExist(String userName) {
        try (Scanner scanner = new Scanner(new File("data/users.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("\"user_name\":\"" + userName + "\"")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file data/users.txt");
        }
        return false;
    }

    // Validate email theo regex
    public boolean validateEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // Validate số điện thoại bắt đầu bằng 03 hoặc 04 và có 10 chữ số
    public boolean validateMobile(String mobile) {
        return mobile.matches("^(03|04)\\d{8}$");
    }

    // Validate username ≥ 5 ký tự và chỉ có chữ + _
    public boolean validateUsername(String userName) {
        return userName != null && userName.matches("^[a-zA-Z_]{5,}$");
    }

    // Validate password ≥ 5 ký tự, có ít nhất 1 chữ và 1 số
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 5) return false;

        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) hasLetter = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasLetter && hasDigit;
    }

    // Đăng ký khách hàng
    public boolean registerCustomer(String userName, String password, String email, String mobile) {
        if (!validateUsername(userName) || checkUsernameExist(userName)) return false;
        if (!validatePassword(password) || !validateEmail(email) || !validateMobile(mobile)) return false;

        String id = generateUniqueUserId();
        String encrypted = encryptPassword(password);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss"));
        Customer customer = new Customer(id, userName, encrypted, time, "customer", email, mobile);

        try (PrintWriter pw = new PrintWriter(new FileWriter("data/users.txt", true))) {
            pw.println(customer.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Cập nhật hồ sơ
    public boolean updateProfile(String attributeName, String value, Customer customerObject) {
        if (attributeName == null || value == null || customerObject == null) return false;

        switch (attributeName.toLowerCase()) {
            case "user_name":
                if (!validateUsername(value)) return false;
                customerObject.setUserName(value);
                break;
            case "user_password":
                if (!validatePassword(value)) return false;
                String encrypted = encryptPassword(value);
                customerObject.setUserPassword(encrypted);  // mk đã má hóa
                break;
            case "user_email":
                if (!validateEmail(value)) return false;
                customerObject.setUserEmail(value);
                break;
            case "user_mobile":
                if (!validateMobile(value)) return false;
                customerObject.setUserMobile(value);
                break;
            default:
                return false;
        }

        return updateCustomerInFile(customerObject);
    }

    // Ghi lại file users.txt sau khi cập nhật
    private boolean updateCustomerInFile(Customer updatedCustomer) {
        File file = new File("data/users.txt");
        List<String> updatedLines = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("\"user_id\":\"" + updatedCustomer.getUserId() + "\"")) {
                    updatedLines.add(updatedCustomer.toString()); // thay dòng cũ
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (Exception e) {
            return false;
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            for (String line : updatedLines) {
                pw.println(line);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
