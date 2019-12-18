package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    public void testChangeDropdownToSelectMultipleOptions(){
        var dropDownPage = homePage.clickDropDown();
        String option1 = "Option 1";
        String option2 = "Option 2";

        dropDownPage.changeDropDownMenuAttribute();
        dropDownPage.selectFromDropDown(option1);
        dropDownPage.selectFromDropDown(option2);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1) && selectedOptions.contains(option2), "Targeted option not selected");

        /* Instructor's solution
        var dropDownPage = homePage.clickDropDown();
        dropDownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
         */
    }
}
