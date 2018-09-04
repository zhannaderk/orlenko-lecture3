package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.utils.BaseScript;
import myprojects.automation.assignment3.utils.GeneralActions;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        WebDriver driver = null;
        try {
            driver = getConfiguredDriver();
            GeneralActions generalActions = new GeneralActions(driver);
            generalActions.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
            generalActions.createCategory("Category8080");

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
