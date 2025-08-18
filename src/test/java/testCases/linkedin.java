package testCases;
import com.configurations.BaseTest;
import com.configurations.BaseUri;
import dataProviders.Navbar;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class linkedin extends BaseTest {

    @Test(testName = "Login")
    public void login() {
        navigateTo(BaseUri.linkedinUrl());
        Navbar navbar = new Navbar(page);
        Assert.assertTrue(page.locator("[data-test-id=hero__headline]").isVisible());
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickSignIn();
        loginPage.enterEmail("ronylevi99@gmail.com");
        loginPage.enterPassword("Dolce1542");
        loginPage.clickSignInButton();
        Assert.assertTrue(loginPage.isProfileVisible());
    }
}
