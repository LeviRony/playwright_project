package configurations;

import static configurations.AutomationEnvProperties.ENV_TYPE;

public class BaseUri {

    public static String playwrightUrl() {
        if ("STG".equalsIgnoreCase(ENV_TYPE)) {
            return "https://playwright.dev";
        } else if ("PROD".equalsIgnoreCase(ENV_TYPE)) {
            return "https://playwright.com";
        } else {
            return "https://playwright.dev"; // default URL
        }
    }

}