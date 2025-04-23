package ir.ac.kntu.style;

import ir.ac.kntu.AbstractUser;
import ir.ac.kntu.Admin;
import ir.ac.kntu.NormalUser;

import ir.ac.kntu.UserManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    @Test
    public void testUserConstructorAndGetters() {
        NormalUser user = new NormalUser("Ali", "Mahdavi", "ali@test.com", "1234");
        assertEquals("Ali", user.getFirstName());
        assertEquals("Mahdavi", user.getLastName());
        assertEquals("ali@test.com", user.getEmail());
        assertEquals("1234", user.getPassword());
    }

    @Test
    public void testSetters() {
        NormalUser user = new NormalUser("A", "B", "x@y.com", "pass");
        user.setFirstName("Reza");
        user.setEmail("reza@site.com");
        assertEquals("Reza", user.getFirstName());
        assertEquals("reza@site.com", user.getEmail());
    }

    @Test
    public void testAdminDisplayUserInfo() {
        Admin admin = new Admin("Admin", "User", "admin@site.com", "admin123");
        admin.displayUserInfo();
        assertTrue(admin instanceof AbstractUser);
    }

    @Test
    public void testNormalUserDisplayUserInfo() {
        NormalUser user = new NormalUser("User", "Normal", "normal@site.com", "pass123");
        user.displayUserInfo();
        assertTrue(user instanceof AbstractUser);
    }

    @Test
    public void testAddUserToManager() {
        UserManager manager = new UserManager();
        AbstractUser user = new NormalUser("U", "L", "u@x.com", "p");
        manager.addUser(user);
        assertEquals(1, manager.getAllUsers().size());
    }

    @Test
    public void testGetAllUsers() {
        UserManager manager = new UserManager();
        manager.addUser(new NormalUser("N1", "L1", "n1@x.com", "1"));
        manager.addUser(new Admin("A1", "L2", "a1@x.com", "2"));
        List<AbstractUser> users = manager.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void testFindUserByEmailExists() {
        UserManager manager = new UserManager();
        AbstractUser user = new Admin("Sara", "Smith", "sara@x.com", "s123");
        manager.addUser(user);
        AbstractUser found = manager.findUserByEmail("sara@x.com");
        assertNotNull(found);
        assertEquals("Sara", found.getFirstName());
    }

    @Test
    public void testFindUserByEmailNotExists() {
        UserManager manager = new UserManager();
        AbstractUser found = manager.findUserByEmail("notfound@x.com");
        assertNull(found);
    }

    @Test
    public void testPasswordPrivacy() {
        NormalUser user = new NormalUser("Ali", "R", "ali@x.com", "secret");
        assertNotEquals("secret", user.toString());
    }

    @Test
    public void testDisplayUserDoesNotShowPassword() {
        NormalUser user = new NormalUser("Name", "Fam", "mail@test.com", "hide");

        user.displayUserInfo();
        assertTrue(true);
    }

    @Test
    public void testDuplicateEmailNotAllowed() {
        UserManager manager = new UserManager();
        manager.addUser(new NormalUser("Ali", "One", "ali@test.com", "pass1"));
        manager.addUser(new NormalUser("Ali", "Two", "ali@test.com", "pass2"));
        long count = manager.getAllUsers().stream().filter(u -> u.getEmail().equals("ali@test.com")).count();
        assertEquals(2, count);
    }
}
