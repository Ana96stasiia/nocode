package Tests.SignUp;

import com.codeborne.selenide.Selenide;
import Pages.SignUpPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("My Epic")
@Feature("My Feature")

public class AgreeCheckBoxTest extends BaseTest {
    @Test
    @Description("This is a agree check box test." +
            "Expected result: Expected result: checkbox \"I agree to the terms of the Privacy Policy\" is displayed.")
    public void testAgreeCheckbox() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open(url1);
        if (signUpPage.isAgreeCheckboxDisplayed()) {
            signUpPage.checkAgreeCheckbox();
        } else {
            System.out.println("Checkbox is not displayed.");
        }
        Selenide.sleep(2000);
        signUpPage.checkAgreeCheckbox();
    }
}