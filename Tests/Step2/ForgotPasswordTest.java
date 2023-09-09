package Tests.Step2;

import Pages.SignInPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("My Epic")
@Feature("My Feature")

public class ForgotPasswordTest extends BaseTest {
    @Test
    @Description("The link a forgot password." +
            "Expected result: when clicking on the link forgot password, there is password recovery form.")
    public void testForgotPasswordLink() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url5);

        // Click the "Forgot password" link
        signInPage.clickForgotPasswordLink();

        // Check that the password recovery form is opened
        boolean isFormVisible = signInPage.isPasswordRecoveryFormVisible();
        assertTrue(isFormVisible, "Password recovery form is not visible");
    }
}