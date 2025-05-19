import java.util.Scanner;
public class IOInterface {
    public static IOInterface getInstance() {
        return new IOInterface();
    }
    public String[] getUserInput(String message, int numofArgs){
        String[] inputs = new String[numofArgs];
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        for (int i = 0; i < numofArgs; i++) {
            inputs[i] = scanner.nextLine();
        }
        scanner.close();
        return inputs;
    }
    public void mainMenu() {
        System.out.println("(1) Login");
        System.out.println("(2) Register");
        System.out.println("(3) Quit");
    }
    public void adminMenu() {
        System.out.println("(1) Show products");
        System.out.println("(2) Add customers");
        System.out.println("(3) Show customers");
        System.out.println("(4) Show orders");
        System.out.println("(5) Generate test data");
        System.out.println("(6) Generate all statistical figures");
        System.out.println("(7) Delete all data");
        System.out.println("(8) Logout");
    }
    public void customerMenu() {
        System.out.println("(1) Show profile");
        System.out.println("(2) Update profile");
        System.out.println("(3) Show products");
        System.out.println("(4) Show history orders");
        System.out.println("(5) Generate all consumption figures");
        System.out.println("(6) Logout");
    }
    public void showList(String userRole, String listType, java.util.List<?> objectList, int pageNumber, int totalPages) {
        for (int i = 0; i < objectList.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + objectList.get(i));
        }
    }
    public void printErrorMessage(String errorSource, String errorMessage) {
        System.out.println(errorMessage);
    }
    public void printMessage (String message) {
        System.out.println(message);
    }
    public void printObject(Object targObject) {
        System.out.println(targObject);
    }
}
