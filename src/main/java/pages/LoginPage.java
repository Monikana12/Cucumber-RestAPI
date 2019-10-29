package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy(xpath = "//a[@href='https://www.facebook.com']")
    WebElement facebooklogo;


    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='u_0_b']")
    WebElement loginField;

    @FindBy(xpath = "")
    WebElement loginButton;

    public void homepageIsDisplayed(){
        Assert.assertEquals(facebooklogo.isDisplayed(),true,"facebook page wasn't displayed");

    }

    public void emailIsDisplayed(){
        Assert.assertEquals(emailField.isDisplayed(),true,"email field wasn't displayed");

    }
    public void passwordIsDisplayed(){
        Assert.assertEquals(passwordField.isDisplayed(),true,"password field wasn't displayed");

    }
    public void loginIsDisplayed(){
        Assert.assertEquals(loginButton.isDisplayed(),true,"login button wasn't displayed");

    }
    public void clickOnLoginButton(){
        loginButton.click();

    }

    public void fillUserNamePasswordField(String user,String pass) {
        emailField.sendKeys(user);
        passwordField.sendKeys(pass);

    }

}
