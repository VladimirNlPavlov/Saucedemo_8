package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void lockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.getMsgVisible());
        assertEquals(loginPage.getTitleText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void noUsernameLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertTrue(loginPage.getMsgVisible());
        assertEquals(loginPage.getTitleText(), "Epic sadface: Username is required");
    }

    @Test
    public void noPasswordLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertTrue(loginPage.getMsgVisible());
        assertEquals(loginPage.getTitleText(), "Epic sadface: Password is required");
    }

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret");
        assertTrue(loginPage.getMsgVisible());
        assertEquals(loginPage.getTitleText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.productsPageOpened());
        assertTrue(productsPage.pageTitleIsVisible());
        assertEquals(productsPage.getTitleText(), "Products");
    }
}
