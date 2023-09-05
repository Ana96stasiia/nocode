package Tests.SignUp.Student;

import Pages.SignUpPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")
public class DoNotEnterNameAndEmail extends BaseTest {
    @Test
    @Description("This is a do not enter name and email test." +
            "Expected result: unsuccessful login. Error: Please make sure there are no empty required fields.")
    public void signUpWithDoNotEnterNameAndEmail() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        // Select the teacher role
        signUpPage.selectStudentOption();

        // Check the "I agree" checkbox
        signUpPage.checkAgreeCheckbox();

        // Fill in the registration form
        signUpPage.enterPassword(studentPassword);

        // Click the "Sign Up" button
        signUpPage.clickSignUpButton();

        // Verify the successful registration message
        signUpPage.getRegistrationFailureMessage().shouldHave(text("Please make sure there are no empty required fields."));
    }
}

