package ir.ac.kntu;

import java.util.List;

public class Admin extends AbstractUser {
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @Override
    public String displayUserInfo() {
        return this.toString();
    }

    public String viewAllUsers(List<AbstractUser> users){
        return users.toString();
    }
}
