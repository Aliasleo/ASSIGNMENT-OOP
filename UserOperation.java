package Operation;
import java.util.Random;

public class UserOperation {
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
        String chars = "abcdefghiklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomStr = new StringBuilder(); 
        Random rand = new Random();

        while (randomStr.length() < userPassword.length()*2){
            randomStr.append(chars.charAt(rand.nextInt(chars.length())));
        }

        StringBuilder encrypted = new StringBuilder("^^"); //bat dau
        for (int i=0;i< userPassword.length();i++){
            encrypted.append(randomStr.charAt(i*2)); // random dau tien
            encrypted.append(randomStr.charAt(i*2+1)); // random thu 2
            encrypted.append(randomStr.charAt(i)); // mk
        }
        encrypted.append("$$"); // ket thuc
        return encrypted.toString();
    }


    public String decryptedPassword (String encrypted){
        if (!encrypted.startsWith("^^") || !encrypted.endsWith("$$")) return null;
        String core = encrypted.substring(2, encrypted.length() - 2);
        StringBuilder password = new StringBuilder();

        for(int i=0;i<core.length();i+=3){
            password.append(core.charAt(i+2)); //lay dung ky tu goc cua user
        }
        return password.toString();
    }

}
