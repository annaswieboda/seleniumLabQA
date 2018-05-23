package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-success")
    private WebElement createButtonElm;

    @FindBy(css = ".user-profile")
    private WebElement userProfileElm;

    public HomePage assertButtonCreateYourFirstProcessIsShown() {
        Assert.assertTrue(createButtonElm.getText().contains("Create your first process"));

        return this;
    }

    public HomePage assertUserProfile() {
        Assert.assertTrue(userProfileElm.getText().contains("test@test.com"));
        return this;

    }
}



