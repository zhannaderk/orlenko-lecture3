package myprojects.automation.assignment3.Pages;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * For login page.
 */
public class LoginPage {
    private WebDriver webDriver;

    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginButton = By.name("submitLogin");

    public LoginPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(Properties.getBaseAdminUrl());
    }

    public void populateEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

        public void populatePasswordInput(String password){
            webDriver.findElement(passwordInput).sendKeys(password);
        }

        public void clickLoginButton() {
            webDriver.findElement(loginButton).click();
        }
    }
