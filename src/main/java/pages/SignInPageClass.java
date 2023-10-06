package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageClass extends BasePage {

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
        super(driver);
    }

    public void tryToSignIn (String email, String password) {
        typeTextInElement(emailInputField, email);
        typeTextInElement(passwordInputField, password);
        clickOnElement(signInButton);
    }

    public String getErrorMessage_InvalidLogin () {
        return getTextOfElement(authenticationFailedError);
    }

    public void clickOnShowOrHidePasswordButton () {
        clickOnElement(showOrHidePasswordButton);
    }

    public void typeTextIntoPasswordInputField (String password) {
        typeTextInElement(passwordInputField, password);
    }

    public String getTypeAttributeOfPasswordInputField () {
        return getAttributeOfElement(passwordInputField, "type");
    }

    public String getTextOfHideOrShowPasswordButton () {
        return getTextOfElement(showOrHidePasswordButton);
    }
}
