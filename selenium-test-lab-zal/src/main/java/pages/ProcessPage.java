package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProcessPage extends HomePage {
    public ProcessPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "Add new process")
    private WebElement newProcessBtn;

    public CreateProcessPage addProcess() {
        newProcessBtn.click();
        return new CreateProcessPage(driver);
    }
}