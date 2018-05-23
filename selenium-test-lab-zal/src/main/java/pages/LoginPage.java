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

    @FindBy(css = "#Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css="button[type=submit")
    private WebElement loginBtn;

    public CreateAccountPage goToRegisterPage() {
        registerLnk.click();
        return new CreateAccountPage(driver);
    }

    public LoginPage typeEmail(String email){
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;

    }

    public LoginPage typePassword (String password){
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin(){
        loginBtn.click();
        return new HomePage(driver);
    }

}
