package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nikitin Ruslan on 06.07.2017.
 */
@CucumberOptions (features = {"src/test/java/Features"}, glue = "steps")
public class YaLoginSteps extends AbstractTestNGCucumberTests{
    public static final String URL = "http://www.yandex.ru/";
    WebDriver driver;
    WebDriverWait wait;

    @Given("^Navigate to the yandex login page$")
    public void navigateToTheYandexLoginPage() throws Throwable {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @When("^I enter valid ([^\"]*) and ([^\"]*)$")
    public void iEnterValidUsernameAndPassword(String username, String password) throws Throwable {
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("passwd")).sendKeys(password);
    }

    @And("^I press login button$")
    public void iPressLoginButton() throws Throwable {
        driver.findElement(By.cssSelector("button.auth__button")).click();
    }

    @Then("^I should see the yandex inbox page$")
    public void iShouldSeeTheYandexInboxPage() throws Throwable {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.mail-App-Header-Item_left")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.mail-User-Name")).getText(), "v.m.varga");
        if (driver != null)
            driver.quit();
    }
}
