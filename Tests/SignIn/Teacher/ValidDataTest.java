package Tests.SignIn.Teacher;

import io.qameta.allure.Description;
import Pages.SignInPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;

public class ValidDataTest extends BaseTest {
    @Test
    @Description("This is a valid data teacher test." +
            "Expected result: successful login. +" +
            "On the page text is Welcome to NoCode University's Student Portal.")
    //Preconditions: this user must be registered on the site!
    public void signInWithValidData() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Fill in the authorization form
        signInPage.enterEmailTeacher(teacherEmail);
        signInPage.enterPasswordTeacher(teacherPassword);

        // Click the "Sign In" button
        signInPage.clickSignInButton();

        // Verify the successful registration message
        signInPage.getAuthorizationSuccessTeacherMessage().shouldHave(text("Welcome to NoCode University's Student Portal"));
    }
}

