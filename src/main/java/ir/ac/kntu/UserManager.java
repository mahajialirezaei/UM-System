package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private ArrayList<AbstractUser> users = new ArrayList<AbstractUser>();

    public void addUser(AbstractUser user){
        users.add(user);
    }

    public ArrayList<AbstractUser> getAllUsers(){
        return users;
    }

    public AbstractUser findUserByEmail(String email){
        for(AbstractUser user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public List<AbstractUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<AbstractUser> users) {
        this.users = users;
    }
}
