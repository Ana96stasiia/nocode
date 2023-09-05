package Tests.SignUp.Teacher;

import Pages.SignUpPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class DoNotEnterNameAndPasswordTest extends BaseTest {
    @Test
    @Description("This is a do not enter name and password test." +
            "Expected result: unsuccessful login. Errors: Please make sure there are no empty required fields. Password must contain at least 6 characters.")
    public void signUpWithDoNotEnterNameAndPassword() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        // Select the teacher role
        signUpPage.selectTeacherOption();

        // Check the "I agree" checkbox
        signUpPage.checkAgreeCheckbox();

        // Fill in the registration form
        signUpPage.enterEmail(teacherEmail);

        // Click the "Sign Up" button
        signUpPage.clickSignUpButton();

        // Verify the successful registration message
        signUpPage.getRegistrationFailureMessage().shouldHave(text("Please make sure there are no empty required fields."));
    }
}