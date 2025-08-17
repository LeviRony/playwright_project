package dataProviders;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import static org.testng.Assert.assertTrue;

public class Navbar {

    private final Page page;

    public Navbar(Page page) {
        this.page = page;
    }

    private final String toggleButton = "button[aria-label='Toggle navigation bar']";
    private final String docsLink = "a[href='//docs/intro']";
    private final String apiLink = "a[href='//docs/api/class-playwright']";
    private final String dropdownLink = "a[role='button'][href='#']";
    private final String accessibilityLink = "a[href='//docs/accessibility-testing']";
    private final String communityLink = "a[href='//community/welcome']";

    @Step
    public void clickToggleButton() {
        page.click(toggleButton);
    }

    @Step
    public void clickDocsLink() {
        page.click(docsLink);
        assertTrue(page.url().contains("//docs/intro"));
    }

    @Step
    public void clickApiLink() {
        page.click(apiLink);
    }

    @Step
    public void hoverOverJavaDropdown() {
        page.hover(dropdownLink);
    }

    @Step
    public void clickJavaAccessibilityLink() {
        page.click(accessibilityLink);
    }

    @Step
    public void clickCommunityLink() {
        page.click(communityLink);
    }
}
