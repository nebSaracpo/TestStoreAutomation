import drivers.DriverFactory;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPageClass;
import pages.SignInPageClass;
import strings.Strings;

public class SignInTestClass extends BaseTest {

    HeaderPageClass headerBar;
    SignInPageClass signInPage;

    @BeforeMethod
    public void initialSetup () {
        driver = DriverFactory.createDriver();
        driver.manage().window().setSize(new Dimension(1900, 1000));
        headerBar = new HeaderPageClass(driver);
        signInPage = new SignInPageClass(driver);
        driver.get(Strings.HOMEPAGE_URL);
        headerBar.clickOnSignInButton();
    }

    @AfterMethod
    public void closeDriver () {
        driver.quit();
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
