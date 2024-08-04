package Objects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class TendableSearch {

    WebDriver driver;
    SoftAssert softAssert;

    public TendableSearch(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }

    // Our Story Link
    By ourStoryLinkText = By.xpath("//a[contains(text(),'Our Story ')]");

    // Our Solution Link
    By ourSolutionLinkText = By.xpath("//a[contains(text(),'Our Solution ')]");

    // Who do we work with? Link to verify Our Solution
    By workWithText = By.xpath("//a[contains(text(),'Who do we work with? ')]");

    // Why Tendable? Link
    By whyTendableLinkText = By.xpath("//a[contains(text(),'Why Tendable? ')]");
    
 // Request for a Demo Xpath
    By requestForDemoLoc = By.xpath("//a[contains(text(),'Request A Demo')]");


    // Verify Home Page
    public void verifyHomePage() {
        String expectedUrlHome = "https://www.tendable.com/";
        String actualUrlHome = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrlHome, expectedUrlHome, "URL Validation Failed!");

        boolean isDisplayed = driver.findElement(requestForDemoLoc).isDisplayed();
        boolean isEnabled = driver.findElement(requestForDemoLoc).isEnabled();
        softAssert.assertTrue(isDisplayed, "'Request a Demo' button is not displayed.");
        softAssert.assertTrue(isEnabled, "'Request a Demo' button is not enabled.");

        softAssert.assertAll();
    }

    // Verifying Our Story
    public void verifyOurStory() {
        try {
            driver.findElement(ourStoryLinkText).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while clicking 'Our Story' link: " + e.getMessage());
        }
        String expectedUrl = "https://www.tendable.com/our-story";
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Our Story Validation Failed!");

        boolean isDisplayed = driver.findElement(requestForDemoLoc).isDisplayed();
        boolean isEnabled = driver.findElement(requestForDemoLoc).isEnabled();
        softAssert.assertTrue(isDisplayed, "'Request a Demo' button is not displayed.");
        softAssert.assertTrue(isEnabled, "'Request a Demo' button is not enabled.");

        softAssert.assertAll();
    }

    // Verifying Our Solution
    public void verifyOurSolution() {
        WebElement ourSolWebElem = driver.findElement(ourSolutionLinkText);
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(ourSolWebElem).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while mouse hovering to 'Our Solution' link: " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement workWithTextWebElem = wait.until(ExpectedConditions.visibilityOfElementLocated(workWithText));
        String text = workWithTextWebElem.getText();
        softAssert.assertEquals(text, "WHO DO WE WORK WITH?", "Our Solution Validation Failed!");

        boolean isDisplayed = driver.findElement(requestForDemoLoc).isDisplayed();
        boolean isEnabled = driver.findElement(requestForDemoLoc).isEnabled();
        softAssert.assertTrue(isDisplayed, "'Request a Demo' button is not displayed.");
        softAssert.assertTrue(isEnabled, "'Request a Demo' button is not enabled.");

        softAssert.assertAll();
    }

    // Verifying Why Tendable?
    public void whyTendable() {
        try {
            driver.findElement(whyTendableLinkText).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while clicking 'Why Tendable?' link: " + e.getMessage());
        }
        String expectedUrl = "https://www.tendable.com/why-tendable";
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Why Tendable Validation Failed!");

        boolean isDisplayed = driver.findElement(requestForDemoLoc).isDisplayed();
        boolean isEnabled = driver.findElement(requestForDemoLoc).isEnabled();
        softAssert.assertTrue(isDisplayed, "'Request a Demo' button is not displayed.");
        softAssert.assertTrue(isEnabled, "'Request a Demo' button is not enabled.");

        softAssert.assertAll();
    }
    
}
