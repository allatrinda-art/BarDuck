package pages.object.helpers;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //File screenshot = (TakesScreenshot)
    }

}
