package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageClass extends BasePage {

    @FindBy (xpath = "//a[@title=\"Log in to your customer account\"]")
    WebElement signInButton;

    @FindBy (className = "account")
    WebElement accountFirstAndLastNameButton;

    public HeaderPageClass(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton () {
        clickOnElement(signInButton);
    }

    public boolean isAccountFirstAndLastNameButtonDisplayed () {
        return isElementDisplayed(accountFirstAndLastNameButton);
    }
}
