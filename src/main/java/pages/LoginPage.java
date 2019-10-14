package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy(xpath = "//*[@class='fb_logo img sp_lFwffOkkE26_2x sx_4444a2']")
    WebElement facebooklogo;


    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    public void homepageIsDisplayed(){
        Assert.assertEquals(facebooklogo.isDisplayed(),true,"facebook page wasn't displayed");

    }

    public void emailIsDisplayed(){
        Assert.assertEquals(emailField.isDisplayed(),true,"email field wasn't displayed");

    }


}
