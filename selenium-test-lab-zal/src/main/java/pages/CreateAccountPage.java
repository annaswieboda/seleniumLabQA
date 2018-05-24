package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAccountPage extends HomePage{
    protected WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(css = "#ConfirmPassword-error")
    private WebElement confirmPasswordErrorTxt;

    @FindBy(css = ".text-danger.validation-summary-errors > ul > li")
    private WebElement passwordError;

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

    public HomePage registerNewUser() {
        registerBtn.click();
        return new HomePage(driver);
    }


    public CreateAccountPage registerWithError() {
        registerBtn.click();
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage assertPasswordDoNotMatch() {
        Assert.assertTrue(confirmPasswordErrorTxt.getText().contains("The password and confirmation password do not match."));

        return this;
    }

    public CreateAccountPage assertPasswordErrorIsShown(String errorMessage) {
        Assert.assertTrue(passwordError.isDisplayed());
        Assert.assertEquals(passwordError.getText(), errorMessage);
        return this;
    }

}
