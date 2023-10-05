package pages;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageClass {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//input[@class='form-control']")
    WebElement emailInputField;

    @FindBy (css = "[type='password']")
    WebElement passwordInputField;

    @FindBy (id = "submit-login")
    WebElement signInButton;

    @FindBy (css = ".alert.alert-danger")
    WebElement authenticationFailedError;

    public SignInPageClass (WebDriver driver) {
        this.driver=driver;
        wait = DriverFactory.createWait(driver);
        PageFactory.initElements(driver, this);
    }

    public void tryToSignIn (String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInputField)).clear();
        emailInputField.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public String getErrorMessage_InvalidLogin () {
        return wait.until(ExpectedConditions.visibilityOf(authenticationFailedError)).getText();
    }
}
