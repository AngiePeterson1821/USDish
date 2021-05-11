package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalDriver {
    private ChromeDriver webDriver;
    public WebDriver LocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
