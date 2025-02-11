package pages.object.helpers;

import java.io.InputStream;
import java.util.Properties;

public class Credentials {
    private static Properties props = new Properties();

    static {
        InputStream is = Credentials.class.getResourceAsStream("/credentials.properties");
        try {
            props.load(is);
        } catch (Exception e) {
            System.out.println("Cannot load credentials" + e.getMessage());
        }
    }

    public static String getProperty(String cred) {
        return props.getProperty(cred);
    }
}
