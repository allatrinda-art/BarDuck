package pages.object.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.TakesScreenshot;
import pages.object.WebDriverContainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.openqa.selenium.OutputType.FILE;

public class ScreenshotListener implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            File screenshot = ((TakesScreenshot) WebDriverContainer.getDriver()).getScreenshotAs(FILE);

            try {
                Allure.addAttachment("screenshot", new FileInputStream(screenshot));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}