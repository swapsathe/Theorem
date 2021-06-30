package com.theorem.ui;

import com.theorem.ui.testng.TestNGCustomListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Base Test class to do common setup and cleanup
 */
@Listeners(TestNGCustomListener.class) //this listener reports pass/fail to extent report
public class BaseTest {

    protected WebDriver driver;
    public static String BASE_URL = "http://automationpractice.com/index.php";

    /**
     * Launch browser before each test method
     */
    @BeforeMethod(alwaysRun = true)
    public void launchBrowser(){
        setChromeDriverLocation();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    /**
     * Close the browser instance after each test method execution. Also grab screenshot if test failed.
     */
    @AfterMethod(alwaysRun = true)
    public void closeBrowserAndGrabScreenshot(ITestResult result)
    {
        //Take screenshot only if test failed
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                TakesScreenshot ts=(TakesScreenshot)driver;
                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);
                // Create screenshot directory if it does not exist
                File screenshotDir = new File("screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdir();
                }
                String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                // Copy method  specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileHandler.copy(source, new File("screenshots/"+result.getName()+dateTime+".png"));
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        // close application
        driver.quit();
    }

    /**
     * Set the chrome driver location as per operating system
     */
    private void setChromeDriverLocation(){
        // set chrome driver location as per OS
        String chromeDriverLocation;
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")){
            chromeDriverLocation = new File("src/main/resources/driver/windows/chromedriver.exe").getAbsolutePath();
        } else if (os.contains("mac")){
            chromeDriverLocation = new File("src/main/resources/driver/mac/chromedriver").getAbsolutePath();
        } else {
            chromeDriverLocation = new File("src/main/resources/driver/linux/chromedriver").getAbsolutePath();
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
    }
}
