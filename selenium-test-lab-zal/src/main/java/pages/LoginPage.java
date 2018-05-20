package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;



    public CreateAccountPage goToRegisterPage() {
        registerLnk.click();
        return new CreateAccountPage(driver);
    }

}
