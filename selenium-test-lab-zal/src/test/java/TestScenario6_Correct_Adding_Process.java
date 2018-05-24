import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestScenario6_Correct_Adding_Process extends SeleniumBaseTest {
    @Test
    public void CorrectAddingProcessTest() {

        String processName = UUID.randomUUID().toString().substring(0, 10);
        String processDescription = UUID.randomUUID().toString().substring(0, 10);
        String processNotes = UUID.randomUUID().toString().substring(0, 9);

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcess()
                .addProcess()
                .typeProcessName(processName)
                .typeProcessDescription(processDescription)
                .typeProcessNotes(processNotes)
                .clickCreate();


    }

}
