package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import strings.Strings;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    //added comment


    protected BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Strings.WAIT_TIME));
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement (WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isElementDisplayed (WebElement element) {
        return element.isDisplayed();
    }

    public void typeTextInElement (WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getTextOfElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getAttributeOfElement (WebElement element, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

}
