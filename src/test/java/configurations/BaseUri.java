package configurations;

import static configurations.AutomationEnvProperties.ENV_TYPE;

public class BaseUri {

    static IllegalArgumentException URL_Error_Msg = new IllegalArgumentException("No valid URL found");

    public static String playwrightUrl() {
        if ("STG".equalsIgnoreCase(ENV_TYPE)) {
            return "https://playwright.dev";
        } else if ("PROD".equalsIgnoreCase(ENV_TYPE)) {
            return "https://playwright.com";
        } else {
            throw URL_Error_Msg;
        }
    }
    public static String linkedinUrl() {
        if ("STG".equalsIgnoreCase(ENV_TYPE)) {
            return "https://www.linkedin.com/";
        } else if ("PROD".equalsIgnoreCase(ENV_TYPE)) {
            return "https://www.linkedin.com/";
        } else {
            throw URL_Error_Msg;
        }
    }
}