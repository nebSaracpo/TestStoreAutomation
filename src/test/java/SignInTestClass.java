import org.testng.Assert;
import org.testng.annotations.*;
import strings.Strings;

public class SignInTestClass extends BaseTest {

    @BeforeMethod
    public void navigateTo () {
        driver.get(Strings.HOMEPAGE_URL);
        headerBar.clickOnSignInButton();
    }

    @AfterMethod
    public void deleteCookies () {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void verifySuccessfulLogin () {
        signInPage.tryToSignIn(Strings.VALID_SIGNIN_EMAIL, Strings.VALID_SIGNIN_PASSWORD);
        Assert.assertTrue(headerBar.isAccountFirstAndLastNameButtonDisplayed());

    }

    @Test
    public void verifyInvalidSignIn() {
        signInPage.tryToSignIn(Strings.INVALID_SIGNIN_EMAIL, Strings.INVALID_SIGNIN_PASSWORD);
        Assert.assertEquals(signInPage.getErrorMessage_InvalidLogin(), "Authentication failed.");
    }

    @Test
    public void verifyShowAndHidePassword () {
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "show");
        signInPage.typeTextIntoPasswordInputField(Strings.INVALID_SIGNIN_PASSWORD);
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "password");
        signInPage.clickOnShowOrHidePasswordButton();
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "text");
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "hide");
        signInPage.clickOnShowOrHidePasswordButton();
        Assert.assertEquals(signInPage.getTypeAttributeOfPasswordInputField().toLowerCase(), "password");
        Assert.assertEquals(signInPage.getTextOfHideOrShowPasswordButton().toLowerCase(), "show");
    }
}
