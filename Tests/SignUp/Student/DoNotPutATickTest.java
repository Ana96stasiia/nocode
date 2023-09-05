package Tests.SignUp.Student;

import Pages.SignUpPage;
import Tests.BaseTest;
import static com.codeborne.selenide.Condition.text;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class DoNotPutATickTest extends BaseTest{
    @Test
    @Description("This is a do not put a tick test." +
            "Expected result: unsuccessful login. Error: Please make sure there are no empty required fields.")
    public void signUpWithdoNotPutATIck() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        // Select the teacher role
        signUpPage.selectStudentOption();

        // Fill in the registration form
        signUpPage.enterFullName(studentFullName);
        signUpPage.enterEmail(studentEmail);
        signUpPage.enterPassword(studentPassword);

        // Click the "Sign Up" button
        signUpPage.clickSignUpButton();

        // Verify the successful registration message
        signUpPage.getRegistrationFailureMessage().shouldHave(text("Please make sure there are no empty required fields."));
    }
}
