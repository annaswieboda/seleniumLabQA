import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Zal_WebDriver {
    @Test
    public void PlayWithWebDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        WebElement searchInput = driver.findElement(By.cssSelector("input[name=q]"));
        searchInput.sendKeys("Quality Assurance");
        WebElement searchBtn = driver.findElement(By.cssSelector("input[value='Szukaj w Google']"));
        searchBtn.click();
        driver.quit();

    }
}
