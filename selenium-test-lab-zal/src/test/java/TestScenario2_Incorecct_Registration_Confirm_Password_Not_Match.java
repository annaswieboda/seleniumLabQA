import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestScenario2_Incorecct_Registration_Confirm_Password_Not_Match extends SeleniumBaseTest {
    @Test
    public void CorrectRegistrationTest() {

        String newEmail = UUID.randomUUID().toString().substring(0, 10);

        new LoginPage(driver)

                .goToRegisterPage()
                .typeEmail(newEmail + "g@com")
                .typePassword("Test1!")
                .typeConfirmPassword("Test1!2")
                .registerWithError()
                .assertPasswordDoNotMatch();

    }
}
