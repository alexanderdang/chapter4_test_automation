package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

/*
Overview
- WebDriver and HomePage objects declared
- setUp method will run when launching the application and will executed before any of the other test classes
- When app is launched, we know we are on HomePage so we instantiate it
- HomePage is protected so it will be inherited from other test classes which will have access to this homePage
- @AfterClass method is to quit session once tests are done
 */

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);
        //Provides handle to HomePage because we are on that page. Istantiates HomePage object from the framework section

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

    public void loadHome(){ //Is this not good? Ok without instantiating in method

        driver.get("https://the-internet.herokuapp.com/");
    }

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
