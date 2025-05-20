import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

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
                            System.out.println("You are logged in as customer.\n");
                        }
                    } else {
                        System.out.println("Login failed. Try again.\n");
                    }
                    break;
                case "2":
                    System.out.println("Register feature is not implemented yet.\n");
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
}
