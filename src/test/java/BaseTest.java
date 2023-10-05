import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HeaderPageClass;
import pages.SignInPageClass;

public class BaseTest {

    WebDriver driver;
    HeaderPageClass headerBar;
    SignInPageClass signInPage;

    @BeforeTest
    public void initialSetup() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1900, 1000));
        headerBar = new HeaderPageClass(driver);
        signInPage = new SignInPageClass(driver);

    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
