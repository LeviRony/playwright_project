package configurations;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    // Launch browser once per suite, optionally parameterized
    @BeforeSuite
    @Parameters("browserName")
    public void launchBrowser(@Optional("chromium") String browserName) {
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "edge":
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unknown browser: " + browserName);
        }
    }

    @BeforeMethod
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    public void navigateTest(String uri) {
        page.navigate(uri);
    }

    @AfterMethod
    public void closeContext() {
        if (context != null) context.close();
    }

    @AfterSuite
    public void closeBrowser() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
