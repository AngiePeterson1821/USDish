package usDish;

import StepDefinitions.indexBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class index extends indexBase {
    WebDriver webDriver;
    FluentWait<WebDriver> wait;
    Actions act = new Actions(driver);

    public index() {
        super();
    }

    public void getH1(){
        String heading = getClickableElement(By.xpath("/html/body/div[1]/div[1]/main/section[1]/div/div[2]/h1")).getText();
        //String heading = driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section[1]/div/div[2]/h1")).getText();
        System.out.println("This is our Hero Header" +heading);
    }
    public void clickHeroLink(String arg0){
        //By locator = By.xpath("/html/body/div[1]/div[1]/main/section[1]/div/div[2]/a/button");
        WebElement locator = getClickableElement(By.cssSelector("[data-tracking='hero__button']"));
        locator.click();
        //getClickableElement(locator).click();
        waitForPageLoad();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.usdish.com/packages");
        System.out.println(URL + " is the expected url");
        driver.navigate().to("https://www.usdish.com");
        waitForPageLoad();

    }
    public void galentinesLink() throws InterruptedException {
    waitForPageLoad();
    WebElement element = getClickableElement(By.xpath("/html/body/div[1]/div[1]/main/section[2]/div/div[2]/a/button"));
    //WebElement locator = driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section[2]/div/div[2]/a/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(500);
        getClickableElement(By.xpath("/html/body/div[1]/div[1]/main/section[2]/div/div[2]/a/button")).click();
    }
    public void verifyGalentines(String arg0){
        waitForPageLoad();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.usdish.com/galentines-day-movie-marathon-dream-job/");
        System.out.println(URL + " is the expected url");
        driver.navigate().back();

    }



    public void installLink(String arg0) throws InterruptedException {
        waitForPageLoad();
        By locator = By.xpath("//*/h4[contains(text(),'FREE Installation')]/../a[@href = '/free-installation']");
        WebElement webElement = getClickableElement (locator);
        By webTrustElement = By.cssSelector("[id='onetrust-policy']");
        By closeTrustElementBtn = By.cssSelector("[id='onetrust-accept-btn-handler']");
        if (elementIsVisible(webTrustElement)){
            getClickableElement(closeTrustElementBtn).click();
        }
        elementIsNotVisible(webTrustElement);
        //Thread.sleep(3000);
        webElement.click();



        waitForPageLoad();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.usdish.com/free-installation");
        System.out.println(URL + " is the expected url");
        driver.navigate().to("https://www.usdish.com");
    }


}
