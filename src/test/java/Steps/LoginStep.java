package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikitin Ruslan on 05.07.2017.
 */
public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate to the login page");
    }

    @And("^I enter the following authentication credentials$")
    public void iEnterTheFollowingAuthenticationCredentials(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        System.out.println(data.get(0).get(0).toString());
        System.out.println(data.get(0).get(1).toString());
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The username is" + user.username);
            System.out.println("The username is" + user.password);
        }
    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUserameAndPassword(String username, String password) throws Throwable {
        System.out.println("Username is" + username);
        System.out.println("Password is" + password);
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }


    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("Click login button");
    }

    @Then("^I should see the inbox page$")
    public void iShouldSeeTheInboxPage() throws Throwable {
        System.out.println("I should see the inbox page");
        System.out.println("The driver is " + base.stepInfo);
    }

    @And("^I enter the users email address as email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The email address is " + email);
    }
}
