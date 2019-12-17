package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";
        editorPage.setTextArea(text1);
        editorPage.increaseIndention();
        editorPage.setTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor is incorrect");
    }

    @Test
    public void testNestedFrames(){
        var framesPage = homePage.clickFrames();
        var NestedFramesPage = framesPage.clickNestedFramesLink();
        //NestedFramesPage.printFrameIndexSize(); - Confirmed that page level has 2 frames: top and bottom

        NestedFramesPage.switchToTopFrame(); //Top frame has index of 0
        //NestedFramesPage.printFrameIndexSize(); - Confirmed that top frame has 3 nested frames within it
        int leftFrameIndex = 0;
        NestedFramesPage.switchToFrameByIndex(leftFrameIndex);
        assertEquals(NestedFramesPage.getBodyText(), "LEFT", "Incorrect frame body text");

        NestedFramesPage.switchToOuterParentFrame();
        //NestedFramesPage.printFrameIndexSize(); - Returned index size of 3 indicating we are in top frame
        NestedFramesPage.switchToOuterParentFrame();
        //NestedFramesPage.printFrameIndexSize(); - Returned index size of 2 indicating we are back in page level

        NestedFramesPage.switchToBottomFrame();
        //NestedFramesPage.printFrameIndexSize(); - Returned 0 meaning that bottom frame has no nested frame
        assertEquals(NestedFramesPage.getBodyText(), "BOTTOM", "Incorrect frame body text");
        NestedFramesPage.switchToOuterParentFrame();
        //NestedFramesPage.printFrameIndexSize(); - Returned index size of 2
    }

    /* Instructor's solution
    @Test
    public void testFrameText() {
        var nestedFramesPage = homePage.clickFramesPage().clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left frame text incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom frame text incorrect");
    }
     */
}
