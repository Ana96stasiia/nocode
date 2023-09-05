package Tests.SignIn;

import static com.codeborne.selenide.Condition.*;
import Pages.SignInPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Epic("My Epic")
@Feature("My Feature")

public class SignInButtonTest extends BaseTest {
    @Test
    @Description("This is a sign In button test." +
            "Expected result: successful login. On the page text is \"Welcome to NoCode University's Student Portal\".")
    public void testSignInButton () {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Enter a valid email and password
        signInPage.enterEmailStudent(studentEmail);
        signInPage.enterPasswordStudent(studentPassword);

        // Click on the "Sign In" button
        signInPage.clickSignInButton();

        // Check that successful login page opens
        signInPage.getAuthorizationSuccessStudentMessage().shouldHave(text("Welcome to NoCode University's Student Portal"));
    }
}

