public class User {
    private String userid;
    private String userName;
    private String userPassword;
    private String userRegisterTime;
    private String userRole;

    public User(String userid, String userName, String userPassword, String userRegisterTime, String userRole) {
        this.userid = userid;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRegisterTime = userRegisterTime;
        this.userRole = userRole;
    }

    public User() {
        this.userid = "";
        this.userName = "";
        this.userPassword = "";
        this.userRegisterTime = "";
        this.userRole = "customer";
    }
    @Override
    public String toString() {
    // Return in format: {"user_id":"u_1234567890", "user_name":"xxx",
    // "user_password":"xxx", "user_register_time":"xxx","user_role":"customer"}
    return "{\"user_id\":\"" + userid + "\", \"user_name\":\"" + userName + "\", \"user_password\":\"" + userPassword + "\", \"user_register_time\":\"" + userRegisterTime + "\",\"user_role\":\"" + userRole + "\"}";
    }

}
