package Tests.SignIn.Student;

import Pages.SignInPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class PasswordFieldBlankTest extends BaseTest {
    @Test
    @Description("Do not enter a password in the field to enter password for student." +
            "Expected result: unsuccessful login." +
            "Error with message text Invalid email or password is displayed.")
    public void signInPasswordFieldBlankTest () {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Fill in the authorization form
        signInPage.enterEmailStudent(studentEmail);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        // Verify the successful registration message
        signInPage.getAuthorizationFailureMessage().shouldHave(text("Invalid email or password"));
    }
}

