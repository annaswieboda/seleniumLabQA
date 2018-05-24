package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateProcessPage extends HomePage{
    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Name")
    private WebElement typeNameTxt;

    @FindBy(css = "#Description")
    private WebElement typeDescriptionTxt;

    @FindBy(css = "#Notes")
    private WebElement typeProcessNotesTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;


    public CreateProcessPage typeProcessName(String processName){
        typeNameTxt.clear();
        typeNameTxt.sendKeys(processName);
        return this;
    }

    public CreateProcessPage typeProcessDescription(String processDescription){
        typeDescriptionTxt.clear();
        typeDescriptionTxt.sendKeys(processDescription);
        return this;
    }

    public CreateProcessPage typeProcessNotes(String processNotes){
        typeProcessNotesTxt.clear();
        typeProcessNotesTxt.sendKeys(processNotes);
        return this;
    }

    public ProcessPage clickCreate(){
        createBtn.click();
        return new ProcessPage(driver);
    }
}
