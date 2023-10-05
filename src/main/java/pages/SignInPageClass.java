package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPageClass {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//input[@class='form-control']")
    WebElement emailInputField;

    @FindBy (css = "[type=\'password\']")
    WebElement passwordInputField;

    @FindBy (id = "submit-login")
    WebElement signInButton;

    public SignInPageClass (WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tryToSignIn (String email, String password) {
        //wait.until(ExpectedConditions.elementToBeClickable(emailInputField)).clear();
        emailInputField.sendKeys(email);
        //wait.until(ExpectedConditions.elementToBeClickable(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}
