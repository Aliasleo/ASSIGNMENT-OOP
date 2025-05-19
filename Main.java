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
                break;
            case "2":
                // Handle registration
                break;
            case "3":
                // Handle quit
                break;
            default:
                ioInterface.printErrorMessage("Invalid Input", "Please select a valid option.");
                break;
        }
    }
}
