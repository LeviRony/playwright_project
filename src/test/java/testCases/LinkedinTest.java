package testCases;

import com.configurations.BaseTest;
import com.configurations.BaseUri;
import dataProviders.Navbar;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static com.utilities.PlaywrightUtils.*;
import static org.testng.Assert.*;

public class LinkedinTest extends BaseTest {

    @Test(testName = "Login")
    public void login() {
        navigateTo(BaseUri.linkedinUrl());
        assertTrue(page.locator("[data-test-id=hero__headline]").isVisible());
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickSignIn();
        loginPage.enterEmail("ronylevi99@gmail.com");
        loginPage.enterPassword("Dolce1542");
        loginPage.clickSignInButton();
        assertTrue(loginPage.isProfileVisible());
        Navbar.validateToggleOn();
    }
}
