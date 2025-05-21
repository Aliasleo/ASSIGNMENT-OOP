public class AdminOperation extends Admin {
    public static AdminOperation getInstance() {
        return new AdminOperation();
    }
    public void registerAdmin(String userid, String userName, String password){
        try (java.io.FileWriter fw = new java.io.FileWriter("users.txt", true)) {
            String userJson = String.format(
                "{\"user_id\":\"%s\",\"user_name\":\"%s\",\"user_password\":\"%s\",\"user_register_time\":\"%s\",\"user_role\":\"%s\"}\n",
                userid, userName, UserOperation.getInstance().encryptPassword(password),super.userRegisterTime, "admin"
            );
            fw.write(userJson);
            System.out.println("Register successful! You can now login.\n");
        } catch (Exception e) {
            System.out.println("Error writing to users.txt: " + e.getMessage());
        }
    }

}
