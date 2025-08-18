package pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void clickSignIn() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();
    }

    public void enterEmail(String email) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email or phone")).fill(email);
    }

    public void enterPassword(String password) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
    }

    public void clickSignInButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();
    }

    public boolean isProfileVisible() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rony Levi Me")).isVisible();
    }
}
