package tests;

import drivers.DriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;


//    @BeforeTest
//    @Parameters("browser")
//    public void createDriver (String browser) {
//        driver = DriverFactory.createDriver(browser);
//        driver.manage().window().setSize(new Dimension(1900, 1000));
//    }
//
//    @AfterTest
//    public void closeDriver () {
//        driver.quit();
//    }
}