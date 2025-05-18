public class Admin extends User{
    public Admin(String userid, String userName, String userPassword, String userRegisterTime, String userRole) {
        super(userid, userName, userPassword, userRegisterTime, userRole);
        
    }
    public Admin() {
        super();
        super.userRole = "admin";
    }
    @Override
    public String toString() { 
        return "{\"user_id\":\"" + userid + "\", \"user_name\":\"" + userName + "\", \"user_password\":\"" + userPassword + "\", \"user_register_time\":\"" + userRegisterTime + "\",\"user_role\":\"" + userRole + "\"}";
    }

}
