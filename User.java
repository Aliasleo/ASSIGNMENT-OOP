import java.text.SimpleDateFormat; // Needed for date formatting if setting current time
import java.util.Date; // Needed for Date object
import java.util.Locale; // Needed for SimpleDateFormat
public class User {
    protected String userid;
    protected String userName;
    protected String userPassword;
    protected String userRegisterTime;
    protected String userRole;

    public User(String userid, String userName, String userPassword, String userRegisterTime, String userRole) {
        this.userid = userid;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRegisterTime = userRegisterTime;
        this.userRole = userRole;
    }

    public User() {
        this.userid = null;
        this.userName = "Guest";
        this.userPassword = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss", Locale.ENGLISH);
        this.userRegisterTime = dateFormat.format(new Date());
        this.userRole = "customer";
        
    }
     public String getUserId() {
        return userid;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getUserRegisterTime() {
        return userRegisterTime;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserId(String userid) {
        this.userid = userid;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    @Override
    public String toString() {
    // Return in format: {"user_id":"u_1234567890", "user_name":"xxx",
    // "user_password":"xxx", "user_register_time":"xxx","user_role":"customer"}
    return "{\"user_id\":\"" + userid + "\", \"user_name\":\"" + userName + "\", \"user_password\":\"" + userPassword + "\", \"user_register_time\":\"" + userRegisterTime + "\",\"user_role\":\"" + userRole + "\"}";
    }

}
