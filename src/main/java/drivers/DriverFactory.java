package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class DriverFactory {


    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            return  new FirefoxDriver();
        } else {
            throw new RuntimeException("BrowserType Not Supported");
        }

    }


}
