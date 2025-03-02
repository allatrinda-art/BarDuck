package pages.object;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.object.enums.Browser;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import pages.object.enums.OS;

import static pages.object.enums.OS.*;

public class WebDriverContainer {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        if (driver.get() == null) {
//            Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toLowerCase());
//
//            WebDriver newDriver = switch (browser) {
//                case chrome -> {
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--ignore-certificate-errors");
//                    yield new ChromeDriver(options);
//                }
//                case firefox -> new FirefoxDriver();
//                case edge -> new EdgeDriver();
//                case safari -> new SafariDriver();
//            };
//
//            driver.set(newDriver);
//        }
//        return driver.get();
//    }
//
//    public static void closeDriver() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//        }
//    }

    private static WebDriver driver;
//    public static WebDriver getDriver () {
//        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toLowerCase());
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        if (driver == null) {
//            switch (browser) {
//                case chrome -> {
//                    caps.setBrowserName("chrome");
//                    caps.setVersion("133.0.6943.99");
//                    caps.setPlatform(Platform.WIN10);
//                    caps.setAcceptInsecureCerts(true);
//                }
//                case firefox -> new FirefoxDriver();
//                case edge -> new EdgeDriver();
//                case safari -> new SafariDriver();
//            }
////            try {
////                driver = new RemoteWebDriver(new URL("http://192.168.100.32:4444/wd/hub"), caps);
//                driver = new ChromeDriver();
////
////            } catch (MalformedURLException e) {
////                throw new RuntimeException(e);
////            }
//
////            driver = new ChromeDriver();
//        }
//
//        return driver;
//    }
//    public static void closeDriver() {
//        driver.quit();
//        driver = null;
//    }

public static synchronized WebDriver getDriver() {
    if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toLowerCase());
        OS platform = OS.valueOf(System.getProperty("os", "local").toLowerCase());

        if (platform == OS.local) {
            createLocalDriver(browser);
        } else {
            createRemoteDriver(browser, platform);
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
    return driver;
}

    public static synchronized void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void createRemoteDriver(Browser browser, OS platform) {
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (browser) {
            case chrome -> {
//                caps.setBrowserName(CHROME);
                caps.setBrowserName("chrome");
//                    caps.setVersion("133.0.6943.99");
                caps.setAcceptInsecureCerts(true);
            }
//            case firefox -> new FirefoxDriver();
//            case edge -> new EdgeDriver();
//            case safari -> new SafariDriver();
            case firefox -> caps.setBrowserName("firefox");
            case edge -> caps.setBrowserName("MicrosoftEdge");
            case safari -> caps.setBrowserName("safari");
        }
        switch (platform) {
            case windows -> caps.setPlatform(Platform.WINDOWS);
            case linux -> caps.setPlatform(Platform.LINUX);
            case mac -> caps.setPlatform(Platform.MAC);
        }
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.249.1:4444/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createLocalDriver(Browser browser) {
        driver = switch (browser) {
            case chrome -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                yield new ChromeDriver(options);
            }
            case firefox -> new FirefoxDriver();
            case edge -> new EdgeDriver();
            case safari -> new SafariDriver();
        };
    }
}