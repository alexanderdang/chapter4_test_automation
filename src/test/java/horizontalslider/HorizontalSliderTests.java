package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HorizontalSliderTests extends BaseTests {


    /*@Test
    public void testHorizontalSlider(){

        Attempt at conducting test with integer value. Unsuccessful because validation message is String value and
        cannot be compared with an integer value using testNG framework

        int value = 2;
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider(value);
        assertEquals(horizontalSliderPage.getSliderValue()., (value/2), "Slider value incorrect");
    }*/


    @Test
    public void testSlideToWholeNumber(){
        String value = "1";
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderValue(value);
        assertEquals(sliderPage.getSliderValue(), value, "Slider value is incorrect");
    }


}
