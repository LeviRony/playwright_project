package configurations;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static configurations.BaseUri.*;

public class BaseTestApi {

    protected Playwright playwright;
    protected APIRequestContext request;

    @BeforeClass
    public void setupRequest() {
        playwright = Playwright.create();
        request = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(playwrightUrl()) // sample API
        );
    }

    @AfterClass
    public void teardown() {
        if (request != null) request.dispose();
        if (playwright != null) playwright.close();
    }
}
