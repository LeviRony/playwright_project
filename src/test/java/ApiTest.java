import com.microsoft.playwright.*;
import org.testng.annotations.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static org.testng.Assert.*;

public class ApiTest {
    static Playwright playwright;
    static APIRequestContext request;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://jsonplaceholder.typicode.com")); // sample API
    }

    @Test
    public void getPost() {
        APIResponse response = request.get("/posts/1");
        assertTrue(response.ok(), "Response should be OK");

        String body = response.text();
        JsonObject json = JsonParser.parseString(body).getAsJsonObject();

        System.out.println("Title: " + json.get("title").getAsString());
        assertEquals(json.get("id").getAsInt(), 1);
    }

    @AfterClass
    public void teardown() {
        playwright.close();
    }
}
