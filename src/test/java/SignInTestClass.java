import org.testng.Assert;
import org.testng.annotations.*;

public class SignInTestClass extends BaseTest {

    @BeforeMethod
    public void navigateTo () {
        driver.get("http://teststore.automationtesting.co.uk/");
        headerBar.clickOnSignInButton();
    }

    @AfterMethod
    public void deleteCookies () {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void verifySuccessfulLogin () {
        String email = "saracpo@gmail.com";
        String password = "TestUser123!";
        signInPage.tryToSignIn(email, password);
        Assert.assertTrue(headerBar.isAccountFirstAndLastNameButtonDisplayed());

    }
}
