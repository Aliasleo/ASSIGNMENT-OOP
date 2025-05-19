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
        switch (action) {
            case "1":
                // Handle login
                String[] loginInput = ioInterface.getUserInput("Please enter your username and password:", 2);
                String username = loginInput[0];
                String password = loginInput[1];
                
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
    }
}
