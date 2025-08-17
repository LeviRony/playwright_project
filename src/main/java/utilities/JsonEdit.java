package utilities;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonEdit {

    /**
     * Pretty print a Playwright APIResponse JSON body
     */
    public static String prettyPrint(APIResponse response) {
        try {
            String jsonString = response.text(); // Get body as String
            ObjectMapper mapper = new ObjectMapper();
            Object jsonObj = mapper.readValue(jsonString, Object.class);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            String prettyJson = writer.writeValueAsString(jsonObj);

            System.out.println("✅ ===== Pretty JSON Response =====");
            System.out.println(prettyJson);

            return prettyJson;
        } catch (Exception e) {
            System.out.println("❌ Failed to pretty print JSON: " + e.getMessage());
            return null;
        }
    }

    /**
     * Helper method: perform GET request and pretty print JSON
     */
    public static String prettyPrint(APIRequestContext request, String endpoint) {
        try {
            APIResponse response = request.get(endpoint);
            return prettyPrint(response);
        } catch (Exception e) {
            System.out.println("❌ Failed to fetch or pretty print endpoint '" + endpoint + "': " + e.getMessage());
            return null;
        }
    }
}
