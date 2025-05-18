public class Admin extends User{
    public Admin(String userid, String userName, String userPassword, String userRegisterTime, String userRole) {
        super(userid, userName, userPassword, userRegisterTime, userRole);
        
    }
    public Admin() {
        super();
        super.userRole = "admin";
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
        return "{\"user_id\":\"" + userid + "\", \"user_name\":\"" + userName + "\", \"user_password\":\"" + userPassword + "\", \"user_register_time\":\"" + userRegisterTime + "\",\"user_role\":\"" + userRole + "\"}";
    }

}
