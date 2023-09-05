package Tests.SignIn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import Pages.SignInPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class InvalidEmailTest extends BaseTest {
    @Test
    @Description("This is a invalid email test." +
            "Expected result: unsuccessful login. Error with message text Invalid email or password is displayed.")
    public void testInvalidEmail() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Enter a valid password in the password entry field
        signInPage.enterPasswordTeacher(teacherPassword);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        // Check that the error message is displayed
        SelenideElement errorMessage = signInPage.getAuthorizationFailureMessage();
        errorMessage.shouldHave(Condition.text("Invalid email or password"));
    }
}

