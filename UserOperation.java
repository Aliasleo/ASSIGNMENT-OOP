import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class UserOperation extends User {
    private static UserOperation instance = null;
    private UserOperation(){} // constructor private -> ko tajo nhieeuf ddoois tuowngj
    
    public static UserOperation getInstance(){
        if (instance == null){
            instance = new UserOperation();
        }
        return instance;
    }
    
    public String generateUniqueUserId(){
        return "u_" +  String.format("%010d",(int)(Math.random() * 1_000_000_000));
    }
    
    public String encryptPassword(String userPassword) {
        if (userPassword == null) return null;
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomStr = new StringBuilder();
        Random rand = new Random();
        int len = userPassword.length();
        for (int i = 0; i < len * 2; i++) {
            randomStr.append(chars.charAt(rand.nextInt(chars.length())));
        }
        StringBuilder encrypted = new StringBuilder("^^");
        for (int i = 0; i < len; i++) {
            encrypted.append(randomStr.charAt(i * 2));
            encrypted.append(randomStr.charAt(i * 2 + 1));
            encrypted.append(userPassword.charAt(i));
        }
        encrypted.append("$$");
        return encrypted.toString();
    }


    public String decryptPassword(String encryptedPassword) {
        if (encryptedPassword == null || !encryptedPassword.startsWith("^^") || !encryptedPassword.endsWith("$$")) return null;
        String core = encryptedPassword.substring(2, encryptedPassword.length() - 2);
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < core.length(); i += 3) {
            password.append(core.charAt(i + 2));
        }
        return password.toString();
    }

    public boolean checkUsernameExist(String userName) {
        try (Scanner scanner = new Scanner(new File("users.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Tìm "user_name":"abc" trong dòng hiện tại
                if (line.contains("\"user_name\":\"" + userName + "\"")) {
                    return true; // Nếu tìm thấy, trả về true
                }
            }
        } catch (Exception e) {
            System.err.println("Không tìm thấy file users.txt");
        }
        return false; // Nếu không tìm thấy
    }

    public boolean validateUsername(String userName) {
        // Rule 1: Check for null or empty string
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Username validation failed: Username is null or empty.");
            return false;
        }

        // Rule 2: Check length (at least 5 characters)
        if (userName.length() < 5) {
            System.out.println("Username validation failed: Length is less than 5 characters. Current length: " + userName.length());
            return false;
        }
        if (!userName.matches("^[a-zA-Z_]+$")) {
            System.out.println("Username validation failed: Contains invalid characters. Only letters and underscores are allowed.");
            return false;
        }
        return true; // All validation rules passed
    }

    public boolean validatePassword(String userPassword) {
        if (userPassword == null || userPassword.length() < 5) return false;

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char ch : userPassword.toCharArray()) {
            if (Character.isLetter(ch)) hasLetter = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasLetter && hasDigit;
    }

    public User login(String userName, String userPassword) {
        File file = new File("users.txt");
        if (!file.exists()) {
            System.out.println("File users.txt không tồn tại.");
            return null;
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("\"user_name\":\"" + userName + "\"")) {
                    String encryptedPassword = line.replaceAll(".*\\\"user_password\\\":\\\"(.*?)\\\".*", "$1");
                    System.out.println("Encrypted password: " + encryptedPassword);
                    String decrypted = decryptPassword(encryptedPassword);
                    System.out.println("Decrypted password: " + decrypted);
                    if (decrypted != null && decrypted.equals(userPassword)) {
                        // Lấy các trường còn lại
                        String userId = line.replaceAll(".*\\\"user_id\\\":\\\"(.*?)\\\".*", "$1");
                        String registerTime = line.replaceAll(".*\\\"user_register_time\\\":\\\"(.*?)\\\".*", "$1");
                        String role = line.replaceAll(".*\\\"user_role\\\":\\\"(.*?)\\\".*", "$1");
                        // Trả về User object
                        return new User(userId, userName, encryptedPassword, registerTime, role);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file users.txt: " + e.getMessage());
        }
        return null;
    }
}
