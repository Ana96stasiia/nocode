package Tests.SignIn;

import com.codeborne.selenide.Condition;
import Pages.SignInPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("My Epic")
@Feature("My Feature")

public class HidePasswordTest extends BaseTest {
    @Test
    @Description("This is a hide password test." +
            "Expected result: the content of the password field is hidden")
    public void testHidePassword() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Enter a valid password in the password entry field
        signInPage.enterPasswordStudent(studentPassword);

        // Click on the "Show password" icon
        signInPage.clickShowPasswordIcon();

        // Click on the "Hide password" icon
        signInPage.clickHidePasswordIcon();

        // Check that the password input's type attribute is changed back to "password"
        signInPage.getPasswordInput().shouldBe(Condition.visible);
    }
}

