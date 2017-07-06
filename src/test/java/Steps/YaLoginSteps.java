package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Nikitin Ruslan on 06.07.2017.
 */
public class YaLoginSteps {
    WebDriver driver;

    @Given("^Navigate to the yandex login page$")
    public void navigateToTheYandexLoginPage() throws Throwable {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.yandex.ru/");
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

        System.out.println(driver.findElement(By.cssSelector("div.mail-User-Name")).getText());
    }
}
