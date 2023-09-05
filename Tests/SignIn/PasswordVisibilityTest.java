package Tests.SignIn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import Pages.SignInPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
@Epic("My Epic")
@Feature("My Feature")

public class PasswordVisibilityTest extends BaseTest {
    @Test
    @Description("This is a password visibility test." +
            "Expected result: password is not displayed in plaintext when you type.")
    public void testPasswordVisibility() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Enter the valid password in the password entry field
        signInPage.enterPasswordTeacher(teacherPassword);

        // Check that the password input is not displayed as text
        SelenideElement passwordInput = signInPage.getPasswordInput();
        passwordInput.shouldHave(Condition.attribute("type", "password"));
    }
}

