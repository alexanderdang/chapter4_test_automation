package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WindowTests extends BaseTests {



    @Test
    public void testOpenNewTabExample2(){
        var buttonPage = homePage.clickDynamicLoading().openNewTabExample2();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Button not displayed");
    }
}
