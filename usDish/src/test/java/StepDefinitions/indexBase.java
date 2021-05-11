package StepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriver;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class indexBase {
    public WebDriver driver;
    Wait<WebDriver> wait;

    public indexBase() {
        this.driver = new LocalDriver().LocalDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
    }

    public void navigate(String arg0) {
        driver.navigate().to(arg0);
    }

    public void driverCloses() {
        driver.close();
    }

    /**
     * Important, KEEP IT. USE IT
     */
    public void waitForPageLoad() {
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void elementIsNotVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean elementIsVisible(By locator) {
        try{
            WebElement element = driver.findElement(locator);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public WebElement getElement(By locator) {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public void sendKeysRedefined(WebElement element, String value, int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.sendKeys(value);
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
    }

    public void watToBeRefreshed(WebElement webElement){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(webElement)));

    }
}


