package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends SeleniumPage{

    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = ".btn-success")
    private WebElement createButtonElm;

    @FindBy(css = ".user-profile")
    private WebElement userProfileElm;


    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));

        return parent.getAttribute("class").contains("active");
    }


    public ProcessPage goToProcess() {
        if (!isParentExpanded(workspaceNav))
            workspaceNav.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(processesMenu));

        processesMenu.click();

        return new ProcessPage(driver);
    }


    public HomePage assertButtonCreateYourFirstProcessIsShown() {
        Assert.assertTrue(createButtonElm.getText().contains("Create your first process"));

        return this;
    }

    public HomePage assertUserProfile() {
        Assert.assertTrue(userProfileElm.getText().contains("test@test.com"));
        return this;

    }
}



