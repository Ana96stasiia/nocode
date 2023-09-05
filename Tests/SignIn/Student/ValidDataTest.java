package Tests.SignIn.Student;

import io.qameta.allure.Step;

import Pages.SignInPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class ValidDataTest extends BaseTest{
    @Test
    @Description("Enter a valid data student." +
            "Expected result: successful login." +
            "On the page text is Welcome to NoCode University's Student Portal.")
    //Preconditions: this user must be registered on the site!
    public void signInWithValidData() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Fill in the authorization form
        signInPage.enterEmailStudent(studentEmail);
        signInPage.enterPasswordStudent(studentPassword);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        // Verify the successful registration message
        signInPage.getAuthorizationSuccessStudentMessage().shouldHave(text("Welcome to NoCode University's Student Portal"));
    }
}

