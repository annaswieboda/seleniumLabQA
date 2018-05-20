import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.UUID;

public class TestScenario1_Correct_Registration extends SeleniumBaseTest {
    @Test
    public void CorrectRegistrationTest() {
        String newEmail = UUID.randomUUID().toString().substring(0, 10);
        new LoginPage(driver)

                .goToRegisterPage()
                .typeEmail(newEmail + "g@com")
                .typePassword("Test1!")
                .typeConfirmPassword("Test1!")
                .registerNewUser()
                .assertButtonCreateYourFirstProcessIsShown();


    }

}
