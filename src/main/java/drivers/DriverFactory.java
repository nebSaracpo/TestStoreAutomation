package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver createDriver() {
        return new ChromeDriver();
    }

    public static WebDriverWait createWait (WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}
