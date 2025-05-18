public class Customer extends User {
    public String userEmail;
    public String userMobile;
    public Customer(String userid, String userName, String userPassword, String userRegisterTime, String userRole, String userEmail, String userMobile) {
        super(userid, userName, userPassword, userRegisterTime, userRole);
        this.userEmail = userEmail;
        this.userMobile = userMobile;
    }
    public Customer() {
        super();
        this.userEmail = "";
        this.userMobile = "";
     }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUserMobile() {
        return userMobile;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    @Override
    public String toString() { 
        return "{\"user_id\":\"" + userid + "\", \"user_name\":\"" + userName + "\", \"user_password\":\"" + userPassword + "\", \"user_register_time\":\"" + userRegisterTime + "\",\"user_role\":\"" + userRole + "\",\"user_email\":\"" + userEmail + "\",\"user_mobile\":\"" + userMobile + "\"}";
    }
}
