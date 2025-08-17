//package utilities;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import okhttp3.Response;
//
//public class JsonEdit {
//
//    public static String prettyPrint(Response response) {
//        try {
//            String jsonString = response.body().string();
//            ObjectMapper mapper = new ObjectMapper();
//            Object jsonObj = mapper.readValue(jsonString, Object.class);
//            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
//            String prettyJson = writer.writeValueAsString(jsonObj);
//            System.out.println("✅ ===== Pretty JSON Response =====");
//            System.out.println(prettyJson);
//        } catch (Exception e) {
//            System.out.println("❌ Failed to pretty print JSON: " + e.getMessage());
//        }
//        return null;
//    }
//}