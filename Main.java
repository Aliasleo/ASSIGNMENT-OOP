import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("REGISTER ADMIN");
        System.out.print("Enter username: ");
        String userName = sc.nextLine();
        System.out.print("Enter password: ");
        String Password = sc.nextLine();
        AdminOperation adminOp = AdminOperation.getInstance();
        adminOp.registerAdmin(UserOperation.getInstance().generateUniqueUserId(),userName, Password);
        while (running) {
            System.out.println("====== E-Commerce System ======");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.println("===============================");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    UserOperation userOp = UserOperation.getInstance();
                    User user = userOp.login(username, password);
                    if (user != null) {
                        System.out.println("\nLogin successful. Welcome, " + user.getUserName() + "!\n");
                        if (user.getUserRole().equalsIgnoreCase("admin")) {
                            adminMenu(sc);
                        } else {
                            customerMenu(sc);
                        }
                    } else {
                        System.out.println("Login failed. Try again.\n");
                    }
                    break;
                case "2":
                    UserOperation userOpReg = UserOperation.getInstance();
                    String newUserId = userOpReg.generateUniqueUserId();

                    System.out.print("Enter new username: ");
                    String newUsername = sc.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = sc.nextLine();

                    // Kiểm tra hợp lệ
                    if (!userOpReg.validateUsername(newUsername)) {
                        System.out.println("Invalid username. Username must be at least 5 characters, only letters and underscores.\n");
                        break;
                    }
                    if (!userOpReg.validatePassword(newPassword)) {
                        System.out.println("Invalid password. Password must be at least 5 characters, include both letters and digits.\n");
                        break;
                    }
                    if (userOpReg.checkUsernameExist(newUsername)) {
                        System.out.println("Username already exists. Please choose another one.\n");
                        break;
                    }

                    String encryptedPassword = userOpReg.encryptPassword(newPassword);
                    String registerTime = new java.text.SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(new java.util.Date());
                    String role = "customer";

                    // Lưu vào file users.txt
                    try (java.io.FileWriter fw = new java.io.FileWriter("users.txt", true)) {
                        String userJson = String.format(
                            "{\"user_id\":\"%s\",\"user_name\":\"%s\",\"user_password\":\"%s\",\"user_register_time\":\"%s\",\"user_role\":\"%s\"}\n",
                            newUserId, newUsername, encryptedPassword, registerTime, role
                        );
                        fw.write(userJson);
                        System.out.println("Register successful! You can now login.\n");
                    } catch (Exception e) {
                        System.out.println("Error writing to users.txt: " + e.getMessage());
                    }
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
        sc.close();
    }

    public static void adminMenu(Scanner sc) {
        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("====== Admin Menu ======");
            System.out.println("1. Show products");
            System.out.println("2. Add customers");
            System.out.println("3. Show customers");
            System.out.println("4. Show orders");
            System.out.println("5. Generate test data");
            System.out.println("6. Generate all statistical figures");
            System.out.println("7. Delete all data");
            System.out.println("8. Logout");
            System.out.println("=======================");
            System.out.print("Enter your choice: ");
            String adminChoice = sc.nextLine();

            switch (adminChoice) {
                case "1":
                    System.out.println("Show products feature.\n");
                    break;
                case "2":
                    System.out.println("Add customers feature.\n");
                    break;
                case "3":
                    System.out.println("Show customers feature.\n");
                    break;
                case "4":
                    System.out.println("Show orders feature.\n");
                    break;
                case "5":
                    System.out.println("Generate test data feature.\n");
                    break;
                case "6":
                    System.out.println("Generate all statistical figures feature.\n");
                    break;
                case "7":
                    System.out.println("Delete all data feature.\n");
                    break;
                case "8":
                    adminRunning = false;
                    System.out.println("Logout successful.\n");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
    public static void customerMenu(Scanner sc) {
        boolean customerRunning = true;
        while (customerRunning) {
            System.out.println("====== Customer Menu ======");
            System.out.println("1. Show profile");
            System.out.println("2. Update profile");
            System.out.println("3. Show products");
            System.out.println("4. Show history orders");
            System.out.println("5. Generate all consumption figures");
            System.out.println("6. Logout");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");
            String customerChoice = sc.nextLine();

            switch (customerChoice) {
                case "1":
                    System.out.println("Show profile feature.\n");
                    break;
                case "2":
                    System.out.println("Update profile feature.\n");
                    break;
                case "3":
                    System.out.println("Show products feature.\n");
                    break;
                case "4":
                    System.out.println("Show history orders feature.\n");
                    break;
                case "5":
                    System.out.println("Generate all consumption figures feature.\n");
                    break;
                case "6":
                    customerRunning = false;
                    System.out.println("Logout successful.\n");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
