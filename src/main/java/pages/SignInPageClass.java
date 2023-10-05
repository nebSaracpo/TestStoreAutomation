package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitHandler;

public class SignInPageClass {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//input[@class='form-control']")
    WebElement emailInputField;

    @FindBy (css = ".js-visible-password")
    WebElement passwordInputField;

    @FindBy (id = "submit-login")
    WebElement signInButton;

    @FindBy (css = ".alert.alert-danger")
    WebElement authenticationFailedError;

    @FindBy (className = "input-group-btn")
    WebElement showOrHidePasswordButton;

    public SignInPageClass (WebDriver driver) {
        this.driver=driver;
        wait = WaitHandler.createWait(driver);
        PageFactory.initElements(driver, this);
    }

    public void tryToSignIn (String email, String password) {
        WaitHandler.waitUntilElementIsClickable(wait, emailInputField);
        emailInputField.clear();
        emailInputField.sendKeys(email);
        WaitHandler.waitUntilElementIsClickable(wait, passwordInputField);
        passwordInputField.clear();
        typeTextIntoPasswordInputField(password);
        WaitHandler.waitUntilElementIsClickable(wait, signInButton);
        signInButton.click();
    }

    public String getErrorMessage_InvalidLogin () {
        WaitHandler.waitUntilElementIsVisible(wait, authenticationFailedError);
        return authenticationFailedError.getText();
    }

    public void clickOnShowOrHidePasswordButton () {
        WaitHandler.waitUntilElementIsClickable(wait, showOrHidePasswordButton);
        showOrHidePasswordButton.click();
    }

    public void typeTextIntoPasswordInputField (String password) {
        passwordInputField.sendKeys(password);
    }

    public String getTypeAttributeOfPasswordInputField () {
        return passwordInputField.getAttribute("type");
    }

    public String getTextOfHideOrShowPasswordButton () {
        return showOrHidePasswordButton.getText();
    }
}
