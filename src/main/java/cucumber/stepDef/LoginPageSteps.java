package cucumber.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ErrorLoginPage;
import pages.LoginPage;

public class LoginPageSteps {
    public static WebDriver driver;
    LoginPage loginPage;
    ErrorLoginPage errorLoginPage;


    @Given("^I open the browser and navigate to facebook login page$")
    public void i_open_the_browser_and_navigate_to_facebook_login_page()  {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver 2");
        driver =new ChromeDriver();
        driver.get("https://www.facebook.com");

    }

    @When("^I land on facebook homepage i vaildate login page is displayed$")
    public void i_land_on_facebook_homepage_i_vaildate_login_page_is_displayed()  {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.homepageIsDisplayed();

    }

    @Then("^I vaildate email or phone field is displayed$")
    public void i_vaildate_email_or_phone_field_is_displayed() {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.emailIsDisplayed();

    }

    @And("^I vaildate password field is displayed$")
    public void i_vaildate_password_field_is_displayed()  {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.passwordIsDisplayed();

    }

    @And("^I vaildation Login button is displayed$")
    public void i_vaildation_Login_button_is_displayed() {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginIsDisplayed();


    }

    @And("^I quit the browser$")
    public void  i_quit_the_browser(){
        driver.quit();

    }

    @Then("^I write user(.*) and pass(.*)$")
    public void i_write_user_and_pass(String user, String pass)  {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.fillUserNamePasswordField(user,pass);


    }

    @Then("^I click on login button$")
    public void i_click_on_login_button()  {
        loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnLoginButton();

    }
    @Then("^I validate user logged in$")
    public void i_validate_user_logged_in() {
        errorLoginPage = PageFactory.initElements(driver, ErrorLoginPage.class);
        errorLoginPage.validateAlertIsDisplayed();
    }

    }


