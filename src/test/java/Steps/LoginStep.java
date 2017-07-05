package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by Nikitin Ruslan on 05.07.2017.
 */
public class LoginStep {
    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate to the login page");
    }

    @And("^I enter the following authentication credentials$")
    public void iEnterTheFollowingAuthenticationCredentials(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        System.out.println(data.get(0).get(0).toString());
        System.out.println(data.get(0).get(1).toString());
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("Click login button");
    }

    @Then("^I should see the inbox page$")
    public void iShouldSeeTheInboxPage() throws Throwable {
        System.out.println("I should see the inbox page");
    }
}
