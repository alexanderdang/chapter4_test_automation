package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropDown();

        String option = "Option 1"; //Stored as variable because used multiple times
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        //Assert if selected option size is 1, if not then error message is provided
        assertTrue(selectedOptions.contains(option), "Option not selected");
        //Assert if the list of selected options contains the one we tested
    }
}
