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

    @Test
    public void verifyInvalidSignIn() {
        signInPage.tryToSignIn("asdasdasdas@adsa.asd", "asdasdasdasd");
        Assert.assertEquals(signInPage.getErrorMessage_InvalidLogin(), "Authentication failed.");
    }

    @Test
    public void verifyShowAndHidePassword () {
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "show");
        signInPage.typeTextIntoPasswordInputField("qwertyu123");
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "password");
        signInPage.clickOnShowOrHidePasswordButton();
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "text");
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "hide");
        signInPage.clickOnShowOrHidePasswordButton();
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "password");
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "show");
    }
}
