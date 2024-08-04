package TestSce;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.ContactUsPageSearch;
import Objects.TendableSearch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod_TendableSearch {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.tendable.com/");
    }

    @Test(priority = 0)
    public void verifyTendableHomePage() {
        TendableSearch homePage = new TendableSearch(driver);
        homePage.verifyHomePage();
        homePage.verifyOurStory();
        homePage.verifyOurSolution();
        homePage.whyTendable();
    }
    
    @Test(priority = 1)
    public void verifyTendableConatctUsPage() {
    	ContactUsPageSearch contactUsPage = new ContactUsPageSearch(driver);
    	contactUsPage.marketingMessageVerify();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
