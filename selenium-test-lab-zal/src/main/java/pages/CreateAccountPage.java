package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(css = ".btn-success")
    private WebElement createButtonElm;

    @FindBy(css = "#ConfirmPassword-error")
    private WebElement confirmPasswordErrorTxt;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage typeConfirmPassword(String password) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage registerNewUser() {
        registerBtn.click();
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage assertButtonCreateYourFirstProcessIsShown() {
        Assert.assertTrue(createButtonElm.getText().contains("Create your first process"));

        return this;
    }

    public CreateAccountPage assertPasswordDoNotMatch() {
        Assert.assertTrue(confirmPasswordErrorTxt.getText().contains("The password and confirmation password do not match."));

        return this;
    }
}
