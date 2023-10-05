package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPageClass {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//a[@title=\"Log in to your customer account\"]")
    WebElement signInButton;

    @FindBy (className = "account")
    WebElement accountFirstAndLastNameButton;

    public HeaderPageClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInButton () {
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
    }

    public boolean isAccountFirstAndLastNameButtonDisplayed () {
        return accountFirstAndLastNameButton.isDisplayed();
    }
}
