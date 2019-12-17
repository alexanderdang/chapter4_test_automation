package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();

        contextMenuPage.rightClickInBox();
        String alertText = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();

        assertEquals(alertText, "You selected a context menu", "Incorrect alert text");
    }
}
