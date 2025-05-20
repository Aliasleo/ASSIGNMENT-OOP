import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Initialize the IOInterface instance
        IOInterface ioInterface = IOInterface.getInstance();
        
        // Display the main menu
        ioInterface.mainMenu();
        
        // Get user input for the action they want to perform
        String[] userInput = ioInterface.getUserInput("Please select an option:", 1);
        
        // Process the user input
        String action = userInput[0];
        Scanner sc=new Scanner(System.in);
        switch (action) {
            case "1":
                // Handle login
                String[] loginInput = ioInterface.getUserInput("Please enter your username and password:", 2);
                System.out.println("Username: " + loginInput[0]);
                System.out.println("Password: " + loginInput[1]);
                // Validate the inputs
                // Check if the user exists and the password is correct
                // If valid, proceed to the next step
                // If invalid, show an error message
                // For example:
                // UserOperation userOperation = UserOperation.getInstance();
                // if (userOperation.validateUsername(loginInput[0]) && userOperation.validatePassword(loginInput[1])) {
                //     ioInterface.printMessage("Login successful!");
                // } else {
                //     ioInterface.printErrorMessage("Login failed", "Invalid username or password.");
                // }
                                
                break;
            case "2":
                // Handle registration
                String[] registerInput = ioInterface.getUserInput("Please enter your username, password, email, and mobile number:", 4);
                String regUsername = registerInput[0];
                String regPassword = registerInput[1];
                String email = registerInput[2];
                String mobile = registerInput[3];
                // Validate the inputs
                break;
            case "3":
                // Handle quit
                ioInterface.printMessage("Exiting the application. Goodbye!");
                break;
            default:
                ioInterface.printErrorMessage("Invalid Input", "Please select a valid option.");
                break;
        }
        sc.close();
    }
}
