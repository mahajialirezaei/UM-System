package ir.ac.kntu;

public class NormalUser extends AbstractUser {

    public NormalUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @Override
    public String displayUserInfo() {
        return this.toString();
    }


}
