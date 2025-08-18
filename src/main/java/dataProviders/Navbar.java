package dataProviders;

import com.microsoft.playwright.*;
import io.qameta.allure.*;

import static org.testng.Assert.*;

public class Navbar {

    private static Page page;
    private static final String toggleButton = "button[aria-label='Toggle navigation bar']";
    private static final String docsLink = "a[href='//docs/intro']";
    private static final String apiLink = "a[href='//docs/api/class-playwright']";
    private static final String dropdownLink = "a[role='button'][href='#']";
    private static final String accessibilityLink = "a[href='//docs/accessibility-testing']";
    private static final String communityLink = "a[href='//community/welcome']";


    public Navbar(Page page) {
        Navbar.page = page;
    }

    @Step
    public static void clickToggleButton() {
        page.click(toggleButton);
    }

    @Step
    public static void validateToggleOn() {
        Locator toggle = page.locator(toggleButton);
        boolean isOn = toggle.getAttribute("aria-checked").equals("true");
    }

    @Step
    public static void clickDocsLink() {
        page.click(docsLink);
        assertTrue(page.url().contains("//docs/intro"));
    }

    @Step
    public static void clickApiLink() {
        page.click(apiLink);
    }

    @Step
    public static void hoverOverJavaDropdown() {
        page.hover(dropdownLink);
    }

    @Step
    public static void clickJavaAccessibilityLink() {
        page.click(accessibilityLink);
    }

    @Step
    public static void clickCommunityLink() {
        page.click(communityLink);
    }
}
