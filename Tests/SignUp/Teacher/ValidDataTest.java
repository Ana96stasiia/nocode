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

public class ValidDataTest extends BaseTest {
    @Test
    @Description("This is a valid data teacher test." +
            "Expected result: a page will open informing you that your registration was successful.")
    //Description: Enter full name, email and password.
    //Preconditions: such user should not be registered on the site!
    public void signUpWithValidData() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);

        // Select the teacher role
        signUpPage.selectTeacherOption();

        // Check the "I agree" checkbox
        signUpPage.checkAgreeCheckbox();

        // Fill in the registration form
        signUpPage.enterFullName(teacherFullName);
        signUpPage.enterEmail(teacherEmail);
        signUpPage.enterPassword(teacherPassword);

        // Click the "Sign Up" button
        signUpPage.clickSignUpButton();

        // Verify the successful registration message
        signUpPage.getRegistrationSuccessTeacherMessage().shouldHave(text("Welcome to NoCode University's Student Portal"));
    }
}