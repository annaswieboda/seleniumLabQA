import org.testng.annotations.Test;
import pages.LoginPage;

public class TestScenario4_Correct_Login extends SeleniumBaseTest {
    @Test
    public void CorrectLoginTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .assertUserProfile();
    }
}
