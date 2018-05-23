import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestScenario3_Incorrect_Registration_Wrong_Email extends SeleniumBaseTest {
    @DataProvider
    public Object[][] getWrongPassword() {
        return new Object[][]{
                {"test1!", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"Test!!", "Passwords must have at least one digit ('0'-'9')."},
                {"Test11", "Passwords must have at least one non alphanumeric character."}
        };
    }

    @Test(dataProvider = "getWrongPassword")

    public void incorrectRegistration(String wrongPassword, String errorMessage) {

        String newEmail = UUID.randomUUID().toString().substring(0, 10);

        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(newEmail + "g@com")
                .typePassword(wrongPassword)
                .typeConfirmPassword(wrongPassword)
                .registerWithError()
                .assertPasswordErrorIsShown(errorMessage);


    }
}

