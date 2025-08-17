
import configurations.BaseTestApi;
import com.microsoft.playwright.APIResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ApiTest extends BaseTestApi {

    @Test
    public void getPost() {
        APIResponse response = request.get("/posts/1");
        assertTrue(response.ok(), "Response should be OK");

        String body = response.text();
        JsonObject json = JsonParser.parseString(body).getAsJsonObject();

        System.out.println("Title: " + json.get("title").getAsString());
        assertEquals(json.get("id").getAsInt(), 1);
    }
}
