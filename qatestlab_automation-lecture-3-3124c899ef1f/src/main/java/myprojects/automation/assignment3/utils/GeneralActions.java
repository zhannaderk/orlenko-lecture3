package myprojects.automation.assignment3.utils;

import myprojects.automation.assignment3.Pages.CategoryPage;
import myprojects.automation.assignment3.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.populateEmailInput(login);
        loginPage.populatePasswordInput(password);
        loginPage.clickLoginButton();
       // throw new UnsupportedOperationException();
    }
    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickCategorySubmenu();
        categoryPage.clickOnAddCategoryButton();
        categoryPage.populateCategoryName(categoryName);
        categoryPage.saveCategory();
        Assert.assertTrue(ExpectedConditions.presenceOfElementLocated(categoryPage.getCreated()).apply(driver).isDisplayed());
        categoryPage.populateCreatedCatName(categoryName);
        categoryPage.clickSearchButton();
        Assert.assertTrue(ExpectedConditions.textToBePresentInElementLocated(categoryPage.getTableBody(), categoryName).apply(driver));
    //    throw new UnsupportedOperationException();
    }
    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By loader) {
        // TODO implement generic method to wait until page content is loaded
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loader)));

    }

}
