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
public class ShowPasswordTest extends BaseTest {
    @Test
    @Description("This is a show password test." +
            "Expected result: password text is displayed.")
    public void testShowPassword() {
        SignInPage signInPage = new SignInPage();
        signInPage.open(url2);

        // Enter the valid password in the password entry field
        signInPage.enterPasswordTeacher(teacherPassword);

        // Click on the "Show password" icon
        signInPage.clickShowPasswordIcon();

        // Check that the password input's value becomes visible
        signInPage.getPasswordTextInput().shouldBe(Condition.visible);
    }
}

