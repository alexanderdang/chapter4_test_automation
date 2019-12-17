package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Overview
- WebDriver and HomePage objects declared
- setUp method will run when launching the application and will executed before any of the other test classes
- When app is launched, we know we are on HomePage so we instantiate it
- HomePage is protected so it will be inherited from other test classes which will have access to this homePage
- @AfterClass method is to quit session once tests are done
 */

public class BaseTests {

    //private WebDriver driver; - replaced by EventFiringWebDriver implementation
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/"+ result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver(); - replaced by EventFiringWebDriver implementation
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
        goHome();

        /* Not needed after adding goHome()
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        */

        /* Commented-out code block below should be in framework section
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();

        loadHome();
        //driver.get("https://the-internet.herokuapp.com/"); //required to locate next WebElement

        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> menuElements = driver.findElements(By.tagName("li"));
        System.out.println(menuElements.size());
        */

        /*1 - Maximizes the window
        driver.manage().window().maximize();

        2 - Fullscreens the window
        driver.manage().window().fullscreen();

        3 - Specific width (show Chrome iPhoneX emulator)
        Dimension size = new Dimension(375,812);
        driver.manage().window().setSize(size);
         */
        System.out.println(driver.getTitle());
        //driver.quit();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /* Main not required after implementing TestNG and the @BeforeClass annotation
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }
    */

    /* Unsure if better to put in new method and re-instantiate
    public void chapterExercise(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();
        WebElement exampleOneLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        exampleOneLink.click();
    }
     */
}
