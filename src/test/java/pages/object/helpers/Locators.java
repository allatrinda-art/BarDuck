package pages.object.helpers;

import org.openqa.selenium.By;
import pages.object.enums.LocatorType;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties props;

    static {
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            props.load(is);
        } catch (Exception e) {
            System.out.println("Cannot load property" + e.getMessage());
        }
    }

    public static By getProperty(String element) {
        String locator = props.getProperty(element);
        String[] parsedLocator = locator.split("=", 2);
        switch (LocatorType.valueOf(parsedLocator[0])) {
            case css -> {return By.cssSelector(parsedLocator[1]);}
            case id -> {return By.cssSelector(parsedLocator[1]);}
            case name -> {return By.cssSelector(parsedLocator[1]);}
            case xpath -> {return By.cssSelector(parsedLocator[1]);}
        }
        return null;
    }
}
